package station.off;

import java.util.HashMap;
import java.util.Map;

import station.off.negocio.interfaces.ICarro;
import station.off.negocio.utils.carros.GerenciarCarro;
import station.off.negocio.utils.exceptions.InvalidTypeException;

// testando

public final class Main {
	
	public static void main(String[] args) throws InvalidTypeException {
		Principal principal = new Principal();
		
		Map<String, Object> informacao = new HashMap<String, Object>();
		informacao.put("Ano", 2012);
		informacao.put("Modelo", "moto");
		informacao.put("Cor", "Preta");
		informacao.put("Placa", "LLL0000");
		informacao.put("Descricao", "Lavar.");
		
		principal.criarCarro(informacao);
		ICarro carro = GerenciarCarro.pegar(principal, 5);
		
		if ((carro != null)) {
			System.out.println("Carro existe...");
		} else {
			System.out.println("Carro nao encontrado...");
		}
	}

}
