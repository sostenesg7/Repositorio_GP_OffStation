package station.off;

import station.off.negocio.utils.exceptions.InvalidTypeException;

public class Erros {

    public static final InvalidTypeException TIPO_INVALIDO = new InvalidTypeException("Tipo invalido no construtor");
    public static final NullPointerException INSTANCIA_INVALIDA = new NullPointerException("Nao eh possivel criar instancias desse objeto...");

}
