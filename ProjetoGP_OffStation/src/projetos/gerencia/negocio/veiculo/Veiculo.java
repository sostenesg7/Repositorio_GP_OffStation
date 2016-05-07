package projetos.gerencia.negocio.veiculo;

import projetos.gerencia.negocio.cliente.ICliente;

public final class Veiculo implements IVeiculo {

    private ICliente dono;

    public Veiculo(ICliente dono) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public ICliente getDono() {
        return this.dono;
    }

    private void setDono(ICliente dono) {
        this.dono = dono;
    }

    @Override
    public String getPlaca() {
        return null;
    }

    @Override
    public String getDescricao() {
        return null;
    }

    @Override
    public String getEntrada() {
        return null;
    }

    @Override
    public String getSaida() {
        return null;
    }

}
