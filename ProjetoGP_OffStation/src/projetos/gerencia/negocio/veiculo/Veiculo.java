package projetos.gerencia.negocio.veiculo;

import projetos.gerencia.negocio.cliente.ICliente;

public final class Veiculo implements IVeiculo {

    private ICliente dono;
    private int id;
    private String placa;
    private String descricao;
    private String entrada;
    private String saida;

    public Veiculo(ICliente dono) {
        this.setDono(dono);
    }

    @Override
    public ICliente getDono() {
        return this.dono;
    }

    private void setDono(ICliente dono) {
        this.dono = dono;
    }

    @Override
    public int getId() {
        return 0;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String getPlaca() {
        return this.placa;
    }

    private void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String getEntrada() {
        return this.entrada;
    }

    private void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    @Override
    public String getSaida() {
        return this.saida;
    }

    private void setSaida(String saida) {
        this.saida = saida;
    }

}
