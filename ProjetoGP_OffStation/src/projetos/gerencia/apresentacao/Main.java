package projetos.gerencia.apresentacao;

public class Main {

    public static void main(String[] args) {

        /*
         Nessa camada ficará a parte que o usuário utilizará, no caso, os funcionários da oficina
         irão preencher os fomulários e tals, no caso, será a parte gráfia, o GUI
         */
        ControlarCliente novoCliente = new ControlarCliente("Cliente", "Um", "cliente@email.com");
        novoCliente.salvar();
    }

}
