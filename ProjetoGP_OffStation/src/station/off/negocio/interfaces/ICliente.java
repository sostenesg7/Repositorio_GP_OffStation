package station.off.negocio.interfaces;

import jdbchelper.QueryResult;
import station.off.negocio.utils.exceptions.InvalidTypeException;

public interface ICliente {

    public void carregar(QueryResult resultado) throws InvalidTypeException;

    public boolean deletar();

    public int getId();

    public String getNome();

    public String getSobrenome();

    public String getEmail();

}
