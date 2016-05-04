package station.off;

import java.util.Map;
import jdbchelper.JdbcHelper;
import station.off.conexao.Jdbc;
import station.off.conexao.interfaces.IJdbc;
import station.off.negocio.utils.carros.GerenciarCarro;

public class Principal {

    private IJdbc conexao;

    public Principal() {
        this.conectar();
    }

    private void conectar() {
        this.setConexao(new Jdbc(10, 3306, "localhost", "root", "100897", "offstation"));
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

    public void criarCarro(Map<String, Object> informacao) {
        GerenciarCarro.criar(this, informacao);
    }

}
