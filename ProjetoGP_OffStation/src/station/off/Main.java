package station.off;

import java.util.HashMap;
import java.util.Map;
import station.off.negocio.interfaces.IVeiculo;
import station.off.negocio.utils.carros.GerenciarVeiculo;
import station.off.negocio.utils.exceptions.InvalidTypeException;

public final class Main {

    /**
     *
     * @author Luan Augusto
     * @param args
     * @throws InvalidTypeException - Futuramente substituir para try - catch.
     */
    public static void main(String[] args) throws InvalidTypeException {
        Principal principal = new Principal();

        // Dados que serão utilizados no cadastro do veiculo
        Map<String, Object> informacao = new HashMap<String, Object>();
        informacao.put("Ano", 2012);
        informacao.put("Modelo", "moto");
        informacao.put("Cor", "Preta");
        informacao.put("Placa", "LLL0000");
        informacao.put("Descricao", "Lavar.");
        //E AWEEEEEEEEE, AQUIIII PEGANDOOOOO DE BOAAA, OBS: AINDA NAO TESTEI BY: MATTHEW
        //testando pra danilo usar
        
        
        // Cria o carro com as informacões do Map
        GerenciarVeiculo.criar(principal, informacao);

        // Pega o carro com ID 5
        IVeiculo carro = GerenciarVeiculo.pegar(principal, 5);

        if ((carro != null)) {
            System.out.println("Carro existe...");
        } else {
            System.out.println("Carro nao encontrado...");
        }
    }

}
