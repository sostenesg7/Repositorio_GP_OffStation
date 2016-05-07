package projetos.gerencia.negocio.cliente;

import java.util.Map;
import projetos.gerencia.persistencia.cliente.PersistirCliente;

public final class ClienteUtils {
    
    private static ClienteUtils INSTANCIA;
    
    private ClienteUtils() {
        
    }

    public static ClienteUtils getInstancia() {
        if ((ClienteUtils.INSTANCIA == null)) {
            ClienteUtils.INSTANCIA = new ClienteUtils();
        }
        return ClienteUtils.INSTANCIA;
    }
    
    public Map<Integer, ICliente> recuperarClientes() {
        Map<Integer, ICliente> clientes = PersistirCliente.getInstancia().recuperarTodos();
        return clientes;
    }

    public ICliente recuperar(int id) {
        ICliente cliente = PersistirCliente.getInstancia().recuperar(id);
        return cliente;
    }

}
