package station.off.negocio.interfaces;

import station.off.negocio.utils.exceptions.InvalidTypeException;

public interface ICarro {

    public void carregar(Object resultado) throws InvalidTypeException;

    public boolean deletar();

    public int getId();

    public int getAno();

    public String getCor();

    public String getPlaca();

    public String getModelo();

    public String getDescricao();

}
