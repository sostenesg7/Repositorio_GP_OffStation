package projetos.gerencia;

import projetos.gerencia.negocio.funcionario.IFuncionario;
import projetos.gerencia.persistencia.cliente.funcionario.PersistirFuncionario;

public class Principal {

    private static Principal INSTANCIA;
    private IFuncionario funcionario;

    private Principal() {

    }

    public void fazerLogin(String cpf, String senha) {
        if ((this.getFuncionario() == null)) {
            try {
                IFuncionario funcionario = PersistirFuncionario.getInstancia().recuperar(Integer.parseInt(cpf));
                if ((funcionario != null) && (funcionario.getSenha().equals(senha))) {
                    if ((funcionario.getTipo() <= 0)) {
                        System.out.println("Você não tem permissão parar acessar essa area!");
                    } else {
                        this.setFuncionario(funcionario);
                        System.out.printf("Bem vindo '%s'\n", funcionario.getNome());
                    }
                } else {
                    System.err.println("CPF e/ou senha digitados incorretamente...");
                }
            } catch (NumberFormatException error) {
                System.err.println("CPF inválido...");
            }
        } else {
            System.err.printf("Oops... Você já está conectado como '%s'\n", this.getFuncionario().getNome());
        }
    }

    public IFuncionario getFuncionario() {
        return this.funcionario;
    }

    private void setFuncionario(IFuncionario funcionario) {
        this.funcionario = funcionario;
    }

    public static Principal getInstancia() {
        if ((Principal.INSTANCIA == null)) {
            Principal.INSTANCIA = new Principal();
        }
        return Principal.INSTANCIA;
    }

}
