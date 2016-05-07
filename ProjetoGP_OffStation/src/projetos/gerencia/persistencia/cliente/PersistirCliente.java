package projetos.gerencia.persistencia.cliente;

import java.util.HashMap;
import java.util.Map;
import jdbchelper.QueryResult;
import projetos.gerencia.negocio.cliente.Cliente;
import projetos.gerencia.negocio.cliente.ICliente;
import projetos.gerencia.persistencia.Conectar;

public class PersistirCliente {

    private static PersistirCliente INSTANCIA = null;

    private PersistirCliente() {
        // Manter esse construtor como private, apenas 1 instância desse objeto será necessária
    }

    public static PersistirCliente getInstancia() {
        if ((PersistirCliente.INSTANCIA == null)) {
            PersistirCliente.INSTANCIA = new PersistirCliente();
        }

        return PersistirCliente.INSTANCIA;
    }

    public boolean salvar(ICliente cliente) {
        if ((cliente != null)) {
            if ((cliente.getId() > 0)) {
                return this.atualizar(cliente);
            }
            return this.inserir(cliente);
        }
        return false;
    }

    public boolean remover(ICliente cliente) {
        if ((cliente != null)) {
            return Conectar.getInstancia().getJdbc().execute("DELETE FROM `clientes` WHERE ( `id` = ? )", new Object[]{cliente.getId()}) == 1;
        }
        return false;
    }

    private boolean inserir(ICliente cliente) {
        return Conectar.getInstancia().getJdbc().execute("INSERT INTO `clientes` ( `id`, `nome`, `sobrenome`, `email` ) VALUES ( NULL, ?, ?, ? )",
                new Object[]{cliente.getNome(), cliente.getSobrenome(), cliente.getEmail()}) == 1;

    }

    private boolean atualizar(ICliente cliente) {
        return Conectar.getInstancia().getJdbc().execute("UPDATE `clientes` SET ( `nome` = ? ), ( `sobrenome` = ? ), ( `email` = ? ) WHERE ( `id` = ? )",
                new Object[]{cliente.getNome(), cliente.getSobrenome(), cliente.getEmail()}) == 1;
    }

    private ICliente construir(QueryResult resultado) {
        if ((resultado != null)) {
            ICliente cliente = new Cliente(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("sobrenome"), resultado.getString("email"));
            return cliente;
        }
        return null;
    }

    public ICliente recuperar(int id) {
        QueryResult resultado = Conectar.getInstancia().getJdbc().query("SELECT * FROM `clientes` WHERE ( `id` = ? )", new Object[]{id});
        ICliente cliente = null;

        if ((resultado.next())) {
            cliente = this.construir(resultado);
        }

        resultado.close();
        return cliente;
    }

    public Map<Integer, ICliente> recuperarTodos() {
        Map<Integer, ICliente> clientes = new HashMap();
        QueryResult resultado = Conectar.getInstancia().getJdbc().query("SELECT * FROM `clientes`");

        while (resultado.next()) {
            ICliente cliente = this.construir(resultado);
            clientes.put(cliente.getId(), cliente);
        }

        resultado.close();
        return clientes;
    }

}
