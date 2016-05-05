package station.off.negocio.utils.clientes;

import jdbchelper.QueryResult;
import station.off.negocio.interfaces.ICliente;
import station.off.negocio.utils.exceptions.InvalidTypeException;

public class Cliente implements ICliente {

    /**
     *
     * @author Luan Augusto
     * @param resultado QueryResult - Resultado da consulta que será passado
     * para o objeto.
     * @throws InvalidTypeException
     */
    @Override
    public void carregar(QueryResult resultado) throws InvalidTypeException {
        resultado.close();
    }

    /**
     *
     * @author Luan Augusto
     * @return Boolean - Indica se a informação foi removida com sucesso do
     * banco de dados.
     */
    @Override
    public boolean deletar() {
        return false;
    }

    /**
     *
     * @author Luan Augusto
     * @return Integer - ID do cliente gerado pelo banco de dados.
     */
    @Override
    public int getId() {
        return 0;
    }

    /**
     *
     * @author Luan Augusto
     * @return String - Primeiro nome do cliente.
     */
    @Override
    public String getNome() {
        return null;
    }

    /**
     *
     * @author Luan Augusto
     * @return String - Sobrenome do cliente.
     */
    @Override
    public String getSobrenome() {
        return null;
    }

    /**
     *
     * @author Luan Augusto
     * @return String - Email do cliente, caso ele tenha algum ou retorna NULL.
     */
    @Override
    public String getEmail() {
        return null;
    }

}
