package projetos.gerencia.apresentacao;

import projetos.gerencia.negocio.cliente.ClienteUtils;
import projetos.gerencia.negocio.cliente.ICliente;

public class Main {

    public static void main(String[] args) {

        /*
         Nessa camada ficará a parte que o usuário utilizará, no caso, os funcionários da oficina
         irão preencher os fomulários e tals, no caso, será a parte gráfia, o GUI
         */
        
        ControlarCliente novoCliente = new ControlarCliente("Mais", "Testes", "cliente@email.com");
        novoCliente.salvar();
        
        ICliente cliente = ClienteUtils.getInstancia().recuperar(1);
        System.out.println("Primeiro Cliente: " + cliente.getNomeCompleto());
        System.out.println();
        
        System.out.println("--- [ LISTANDO TODO MUNDO ] -------------------");
        for (ICliente iterator : ClienteUtils.getInstancia().recuperarClientes().values()) {
            System.out.println("Cliente " + iterator.getId() + " -> " + iterator.getNomeCompleto());
        }
    }

}
