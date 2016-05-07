package projetos.gerencia;

import jdbchelper.JdbcException;
import projetos.gerencia.exceptions.LoginException;
import projetos.gerencia.negocio.funcionario.IFuncionario;
import projetos.gerencia.persistencia.cliente.funcionario.PersistirFuncionario;

public class Principal {

    private static Principal INSTANCIA;
    private IFuncionario funcionario;

    private Principal() {

    }

    public void fazerLogin(String cpf, String senha) throws LoginException {
        if ((this.getFuncionario() == null)) {
            try {
                IFuncionario funcionario = PersistirFuncionario.getInstancia().recuperar(Integer.parseInt(cpf));
                if ((funcionario != null) && (funcionario.getSenha().equals(senha))) {
                    if ((funcionario.getTipo() <= 0)) {
                        throw new LoginException("Você não tem permissão suficiente.");
                    } else {
                        this.setFuncionario(funcionario);
                    }
                } else {
                    throw new LoginException("Nenhum usuário encontrado com as informações inseridas.");
                }
            } catch(JdbcException error) {
                throw new LoginException("Não foi possível conectar ao banco de dados.");
            } catch (NumberFormatException error) {
                throw new LoginException("CPF digitado de forma incorreta! Use apenas os números.");
            }
        } else {
            throw new LoginException(new StringBuilder().append("Oops... Você já está conectado como '").append(this.getFuncionario().getNome()).append("'.").toString());
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
