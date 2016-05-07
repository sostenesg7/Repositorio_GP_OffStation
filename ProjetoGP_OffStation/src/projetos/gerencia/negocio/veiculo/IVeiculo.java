package projetos.gerencia.negocio.veiculo;

import projetos.gerencia.negocio.cliente.ICliente;

public interface IVeiculo {

    public int getId();

    public ICliente getDono();

    public String getPlaca();

    public String getDescricao();

    public String getEntrada();

    public String getSaida();

}
