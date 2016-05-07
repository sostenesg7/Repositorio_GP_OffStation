package projetos.gerencia.persistencia.cliente;

import projetos.gerencia.negocio.cliente.Cliente;
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

    public boolean salvar(Cliente cliente) {
        if ((cliente.getId() > 0)) {
            return this.atualizar(cliente);
        }
        return this.inserir(cliente);
    }

    private boolean inserir(Cliente cliente) {
        return Conectar.getInstancia().getJdbc().execute("INSERT INTO `clientes` ( `id`, `nome`, `sobrenome`, `email` ) VALUES ( NULL, ?, ?, ? )",
                new Object[]{cliente.getNome(), cliente.getSobrenome(), cliente.getEmail()}) == 1;
    }

    private boolean atualizar(Cliente cliente) {
        return Conectar.getInstancia().getJdbc().execute("UPDATE `clientes` SET ( `nome` = ? ), ( `sobrenome` = ? ), ( `email` = ? ) WHERE ( `id` = ? )",
                new Object[]{cliente.getNome(), cliente.getSobrenome(), cliente.getEmail()}) == 1;
    }

}
