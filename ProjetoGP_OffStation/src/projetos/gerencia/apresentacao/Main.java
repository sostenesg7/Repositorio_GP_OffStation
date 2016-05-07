package projetos.gerencia.apresentacao;

import projetos.gerencia.negocio.cliente.ICliente;
import projetos.gerencia.persistencia.cliente.PersistirCliente;

public class Main {

    public static void main(String[] args) {

        /*
         Nessa camada ficará a parte que o usuário utilizará, no caso, os funcionários da oficina
         irão preencher os fomulários e tals, no caso, será a parte gráfia, o GUI
         */
        
        ControlarCliente novoCliente = new ControlarCliente("Outro", "Teste", "cliente@email.com");
        novoCliente.salvar();
        
        ICliente cliente = PersistirCliente.getInstancia().recuperar(1);
        System.out.println("Nome: " + cliente.getNome());
    }

}
