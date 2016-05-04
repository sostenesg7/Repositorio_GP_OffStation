package station.off;

import java.util.HashMap;
import java.util.Map;
import station.off.negocio.interfaces.ICarro;
import station.off.negocio.utils.carros.GerenciarCarro;
import station.off.negocio.utils.exceptions.InvalidTypeException;

public final class Main {

    public static void main(String[] args) throws InvalidTypeException {
        Principal principal = new Principal();

        // Dados que serão utilizados no cadastro do veiculo
        Map<String, Object> informacao = new HashMap<String, Object>();
        informacao.put("Ano", 2012);
        informacao.put("Modelo", "moto");
        informacao.put("Cor", "Preta");
        informacao.put("Placa", "LLL0000");
        informacao.put("Descricao", "Lavar.");

        // Cria o carro com as informacões do Map
        GerenciarCarro.criar(principal, informacao);
        
        // Pega o carro com ID 5
        ICarro carro = GerenciarCarro.pegar(principal, 5);

        if ((carro != null)) {
            System.out.println("Carro existe...");
        } else {
            System.out.println("Carro nao encontrado...");
        }
    }

}