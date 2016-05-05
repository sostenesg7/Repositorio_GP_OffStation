package station.off;

import jdbchelper.JdbcHelper;
import station.off.conexao.Jdbc;
import station.off.conexao.interfaces.IJdbc;

public class Principal {

    private IJdbc conexao;

    public Principal() {
        this.conectar();
    }

    private void conectar() {
        // Conexoes, porta, host, usuario, senha, database
        this.setConexao(new Jdbc(10, 3306, "localhost", "root", "123456", "offstation"));
    }

    public JdbcHelper getJdbc() {
        return this.getConexao().getJdbc();
    }

    public IJdbc getConexao() {
        return this.conexao;
    }

    private void setConexao(IJdbc conexao) {
        this.conexao = conexao;
    }

}
