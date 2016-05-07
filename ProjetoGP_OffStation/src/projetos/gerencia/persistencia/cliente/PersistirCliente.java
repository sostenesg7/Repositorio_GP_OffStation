package projetos.gerencia.persistencia.cliente;

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
        if ((cliente.getId() > 0)) {
            return this.atualizar(cliente);
        }
        return this.inserir(cliente);
    }

    public ICliente recuperar(int id) {
        if ((id > 0)) {
            QueryResult resultado = Conectar.getInstancia().getJdbc().query("SELECT * FROM `clientes` WHERE `id` = ?", new Object[]{id});

            try {
                if ((resultado.next())) {
                    ICliente cliente = new Cliente(resultado.getInt("id"), resultado.getString("nome"), resultado.getString("sobrenome"), resultado.getString("email"));
                    return cliente;
                }
            } finally {
                resultado.close();
            }
        }
        return null;
    }

    private boolean inserir(ICliente cliente) {
        return Conectar.getInstancia().getJdbc().execute("INSERT INTO `clientes` ( `id`, `nome`, `sobrenome`, `email` ) VALUES ( NULL, ?, ?, ? )",
                new Object[]{cliente.getNome(), cliente.getSobrenome(), cliente.getEmail()}) == 1;
    }

    private boolean atualizar(ICliente cliente) {
        return Conectar.getInstancia().getJdbc().execute("UPDATE `clientes` SET ( `nome` = ? ), ( `sobrenome` = ? ), ( `email` = ? ) WHERE ( `id` = ? )",
                new Object[]{cliente.getNome(), cliente.getSobrenome(), cliente.getEmail()}) == 1;
    }

}
