package projetos.gerencia.apresentacao;

import projetos.gerencia.negocio.veiculo.IVeiculo;
import projetos.gerencia.persistencia.veiculo.PersistirVeiculo;

public class ControlarVeiculo {

    private IVeiculo veiculo;

    public ControlarVeiculo() {
        this.setVeiculo(null);
    }

    public boolean salvar() {
        return PersistirVeiculo.getInstancia().salvar(this.getVeiculo());
    }

    public IVeiculo getVeiculo() {
        return this.veiculo;
    }

    private void setVeiculo(IVeiculo veiculo) {
        this.veiculo = veiculo;
    }

}
