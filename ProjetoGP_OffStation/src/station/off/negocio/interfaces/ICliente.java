package station.off.negocio.interfaces;

import station.off.negocio.utils.exceptions.InvalidTypeException;

public interface ICliente {

	public void carregar(Object resultado) throws InvalidTypeException;

	public boolean deletar();

	public int getId();

	public String getNome();

	public String getSobrenome();

	public String getEmail();

}
