package station.off;

import station.off.negocio.utils.exceptions.InvalidTypeException;

public class Erros {

	public static final InvalidTypeException TIPO_INVALIDO = new InvalidTypeException("Tipo inválido no construtor");
	public static final NullPointerException INSTANCIA_INVALIDA = new NullPointerException("Não é possível criar instâncias desse objeto...");

}
