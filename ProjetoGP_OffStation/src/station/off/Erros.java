package station.off;

import station.off.negocio.utils.exceptions.InvalidTypeException;

public class Erros {

	public static final InvalidTypeException TIPO_INVALIDO = new InvalidTypeException("Tipo inv�lido no construtor");
	public static final NullPointerException INSTANCIA_INVALIDA = new NullPointerException("N�o � poss�vel criar inst�ncias desse objeto...");

}
