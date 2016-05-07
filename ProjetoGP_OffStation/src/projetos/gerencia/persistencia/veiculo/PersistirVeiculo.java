package projetos.gerencia.persistencia.veiculo;

import projetos.gerencia.negocio.veiculo.IVeiculo;

public class PersistirVeiculo {

    private static PersistirVeiculo INSTANCIA = null;

    private PersistirVeiculo() {
        // Manter esse construtor como private, apenas 1 instância desse objeto será necessária
    }

    public static PersistirVeiculo getInstancia() {
        if ((PersistirVeiculo.INSTANCIA == null)) {
            PersistirVeiculo.INSTANCIA = new PersistirVeiculo();
        }

        return PersistirVeiculo.INSTANCIA;
    }
    
    public IVeiculo recuperar(int id) {
        return null;
    }

    public boolean salvar(IVeiculo veiculo) {
        if ((veiculo.getId() > 0)) {
            return this.atualizar(veiculo);
        }
        return this.inserir(veiculo);
    }

    private boolean inserir(IVeiculo cliente) {
        return true;
    }

    private boolean atualizar(IVeiculo cliente) {
        return true;
    }
}
