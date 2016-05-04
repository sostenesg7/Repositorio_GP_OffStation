package station.off.conexao;

import station.off.conexao.interfaces.IJdbc;
import jdbchelper.ConnectionPool;
import jdbchelper.JdbcHelper;
import jdbchelper.PooledDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class Jdbc implements IJdbc {

	private int tamanho;
	private int port;
	private String host;
	private String user;
	private String senha;
	private String base;
	private JdbcHelper jdbc;
	private ConnectionPool pool;
	private MysqlConnectionPoolDataSource source;

	public Jdbc(int tamanho, int port, String host, String user, String senha, String base) {
		this.setTamanho(tamanho);
		this.setPort(port);
		this.setHost(host);
		this.setUser(user);
		this.setSenha(senha);
		this.setBase(base);
		this.conectar();
	}

	private void conectar() {
		this.setSource(new MysqlConnectionPoolDataSource());
		this.getSource().setPort(this.getPort());
		this.getSource().setUser(this.getUser());
		this.getSource().setPassword(this.getSenha());
		this.getSource().setServerName(this.getHost());
		this.getSource().setDatabaseName(this.getBase());

		this.setPool(new ConnectionPool(this.getSource(), this.getTamanho()));
		this.setJdbc(new JdbcHelper(new PooledDataSource(this.getPool())));
	}

	private int getTamanho() {
		return this.tamanho;
	}

	private void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	private int getPort() {
		return this.port;
	}

	private void setPort(int port) {
		this.port = port;
	}

	private String getHost() {
		return this.host;
	}

	private void setHost(String host) {
		this.host = host;
	}

	private String getUser() {
		return this.user;
	}

	private void setUser(String user) {
		this.user = user;
	}

	private String getSenha() {
		return this.senha;
	}

	private void setSenha(String senha) {
		this.senha = senha;
	}

	private String getBase() {
		return this.base;
	}

	private void setBase(String base) {
		this.base = base;
	}

	public JdbcHelper getJdbc() {
		return this.jdbc;
	}

	private void setJdbc(JdbcHelper jdbc) {
		this.jdbc = jdbc;
	}

	private ConnectionPool getPool() {
		return this.pool;
	}

	private void setPool(ConnectionPool pool) {
		this.pool = pool;
	}

	private MysqlConnectionPoolDataSource getSource() {
		return this.source;
	}

	private void setSource(MysqlConnectionPoolDataSource source) {
		this.source = source;
	}

}
