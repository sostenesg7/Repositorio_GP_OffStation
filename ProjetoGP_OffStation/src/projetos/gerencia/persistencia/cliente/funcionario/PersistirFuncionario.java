package projetos.gerencia.persistencia.cliente.funcionario;

import jdbchelper.QueryResult;
import projetos.gerencia.negocio.funcionario.Funcionario;
import projetos.gerencia.negocio.funcionario.IFuncionario;
import projetos.gerencia.persistencia.Conectar;

public class PersistirFuncionario {
    
    private static PersistirFuncionario INSTANCIA = null;
    
    private PersistirFuncionario() {
        
    }

    public static PersistirFuncionario getInstancia() {
        if ((PersistirFuncionario.INSTANCIA == null)) {
            PersistirFuncionario.INSTANCIA = new PersistirFuncionario();
        }
        return PersistirFuncionario.INSTANCIA;
    }
    
    public boolean salvar(IFuncionario funcionario) {
        if ((funcionario != null)) {
            
        }
        return false;
    }

    private boolean inserir(IFuncionario cliente) {
        return false;
    }

    private boolean atualizar(IFuncionario cliente) {
        return false;
    }

    private IFuncionario construir(QueryResult resultado) {
        if ((resultado != null)) {
            IFuncionario funcionario = new Funcionario(resultado.getInt("cpf"), resultado.getInt("tipo"), resultado.getString("nome"), resultado.getString("sobrenome"), resultado.getString("email"), resultado.getString("senha"));
            return funcionario;
        }
        return null;
    }
    
    public IFuncionario recuperar(int cpf) {
        QueryResult resultado = Conectar.getInstancia().getJdbc().query("SELECT * FROM `funcionarios` WHERE ( `cpf` = ? )", new Object[]{cpf});
        IFuncionario funcionario = null;
        
        if ((resultado.next())) {
            funcionario = this.construir(resultado);
        }
        
        resultado.close();
        return funcionario;
    }
    
}
