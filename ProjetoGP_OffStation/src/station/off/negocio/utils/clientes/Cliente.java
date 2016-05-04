package station.off.negocio.utils.clientes;

import jdbchelper.QueryResult;
import station.off.Erros;
import station.off.negocio.interfaces.ICliente;
import station.off.negocio.utils.exceptions.InvalidTypeException;

public class Cliente implements ICliente {

    @Override
    public void carregar(Object resultado) throws InvalidTypeException {
        if ((resultado instanceof QueryResult)) {

        } else {
            throw Erros.TIPO_INVALIDO;
        }
    }

    @Override
    public boolean deletar() {
        return false;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getNome() {
        return null;
    }

    @Override
    public String getSobrenome() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

}
