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
                        throw new LoginException(LoginException.SEM_PERMISSAO, LoginException.SEM_PERMISSAO_ID);
                    } else {
                        this.setFuncionario(funcionario);
                    }
                } else {
                    throw new LoginException(LoginException.NAO_ENCONTRADO, LoginException.NAO_ENCONTRADO_ID);
                }
            } catch(JdbcException error) {
                 throw new LoginException(LoginException.SEM_CONEXOES, LoginException.SEM_CONEXOES_ID);
            } catch (NumberFormatException error) {
                throw new LoginException(LoginException.CPF_INVALIDO, LoginException.CPF_INVALIDO_ID);
            }
        } else {
            throw new LoginException(LoginException.SESSAO_ATIVA, LoginException.SESSAO_ATIVA_ID);
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
