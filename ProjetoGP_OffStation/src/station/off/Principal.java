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
     * Conecta com o banco de dados.
     * 
     * @author Luan Augusto
     */
    private void conectar() {
        // Conexoes, porta, host, usuario, senha, database
        this.setConexao(new Jdbc(10, 3306, "localhost", "offstation", "123456", "offstation"));
    }

    /**
     * 
     * @author Luan Augusto
     * @return JdbcHelper - Responsável pelas consultas ao banco de dados.
     */
    public JdbcHelper getJdbc() {
        return this.getConexao().getJdbc();
    }

    /**
     * 
     * @author Luan Augusto
     * @return IJdbc - Objeto principal de conexão com o banco.
     */
    public IJdbc getConexao() {
        return this.conexao;
    }

    /**
     * 
     * @author Luan Augusto
     * @param conexao IJdbc - Objeto a ser setado como instancia da conexao.
     */
    private void setConexao(IJdbc conexao) {
        this.conexao = conexao;
    }

}
