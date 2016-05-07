package projetos.gerencia;

import projetos.gerencia.negocio.funcionario.IFuncionario;

public class Principal {
    
    private static Principal INSTANCIA;
    private IFuncionario funcionario;
    
    private Principal() {
        
    }
    
    public void fazerLogin(String cpf, String senha) {
        if ((this.getFuncionario() == null)) {
            try {
                
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
