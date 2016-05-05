package station.off;

import jdbchelper.JdbcHelper;
import station.off.conexao.Jdbc;
import station.off.conexao.interfaces.IJdbc;

public class Principal {

    private IJdbc conexao;

    public Principal() {
        this.conectar();
    }

    /**
     * 
     * @author Luan Augusto
     */
    private void conectar() {
        // Conexoes, porta, host, usuario, senha, database
        this.setConexao(new Jdbc(10, 3306, "localhost", "root", "123456", "offstation"));
    }

    /**
     * 
     * @author Luan Augusto
     */
    public JdbcHelper getJdbc() {
        return this.getConexao().getJdbc();
    }

    /**
     * 
     * @author Luan Augusto
     */
    public IJdbc getConexao() {
        return this.conexao;
    }

    /**
     * 
     * @author Luan Augusto
     */
    private void setConexao(IJdbc conexao) {
        this.conexao = conexao;
    }

}
