package station.off.negocio.utils.carros;

import jdbchelper.QueryResult;
import station.off.Principal;
import station.off.negocio.interfaces.IVeiculo;
import station.off.negocio.utils.exceptions.InvalidTypeException;

public final class Veiculo implements IVeiculo {

    private int id;
    private int ano;
    private String cor;
    private String placa;
    private String modelo;
    private String descricao;
    private Principal principal;

    /**
     *
     * @author Luan Augusto
     * @param principal - Classe principal de gerenciamento.
     * @param resultado - Informações do veículo que será passada para os
     * atributos.
     * @throws InvalidTypeException - Lançado quando o tipo do objeto não é o
     * esperado.
     */
    public Veiculo(Principal principal, QueryResult resultado) throws InvalidTypeException {
        this.setPrincipal(principal);
        this.carregar(resultado);
    }

    /**
     *
     * @author Luan Augusto
     * @param resultado QueryResult - Resultado da consulta que será passado
     * para o objeto.
     * @throws InvalidTypeException
     */
    @Override
    public void carregar(QueryResult resultado) throws InvalidTypeException {
        this.setId(resultado.getInt("id"));
        this.setAno(resultado.getInt("Ano"), false);
        this.setDescricao(resultado.getString("Descricao"), false);
        this.setCor(resultado.getString("Cor"), false);
        this.setPlaca(resultado.getString("Placa"), false);
        this.setModelo(resultado.getString("Modelo"), false);
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
        return this.id;
    }

    /**
     *
     * @author Luan Augusto
     * @param id int - ID gerado para o veículo pelo banco de dados.
     */
    private void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @author Luan Augusto
     * @return int - Ano de fabricação do veículo.
     */
    @Override
    public int getAno() {
        return this.ano;
    }

    /**
     *
     * @author Luan Augusto
     * @param ano int - Valor que será atualizado no ano do veículo.
     * @param atualizar boolean - Indica se a informação deve ser gravada no
     * banco de dados.
     */
    private void setAno(int ano, boolean atualizar) {
        this.ano = ano;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Ano` = ? )", new Object[]{this.getAno()});
        }
    }

    /**
     *
     * @author Luan Augusto
     * @return String - Cor do veículo.
     */
    @Override
    public String getCor() {
        return this.cor;
    }

    /**
     *
     * @author Luan Augusto
     * @param cor String - Valor que será atualizado na cor do veículo.
     * @param atualizar boolean - Indica se a informação deve ser gravada no
     * banco de dados.
     */
    private void setCor(String cor, boolean atualizar) {
        this.cor = cor;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Cor` = ? )", new Object[]{this.getCor()});
        }
    }

    /**
     *
     * @author Luan Augusto
     * @return String - Placa do veículo.
     */
    @Override
    public String getPlaca() {
        return this.placa;
    }

    /**
     *
     * @author Luan Augusto
     * @param placa String - Valor que será atualizado na placa do veículo.
     * @param atualizar boolean - Indica se a informação deve ser gravada no
     * banco de dados.
     */
    private void setPlaca(String placa, boolean atualizar) {
        this.placa = placa;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Placa` = ? )", new Object[]{this.getPlaca()});
        }
    }

    /**
     *
     * @author Luan Augusto
     * @return String - Modelo do veículo.
     */
    @Override
    public String getModelo() {
        return this.modelo;
    }

    /**
     *
     * @author Luan Augusto
     * @param modelo String - Valor que será atualizado no modelo do veículo.
     * @param atualizar boolean - Indica se a informação deve ser gravada no
     * banco de dados.
     */
    private void setModelo(String modelo, boolean atualizar) {
        this.modelo = modelo;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Modelo` = ? )", new Object[]{this.getModelo()});
        }
    }

    /**
     *
     * @author Luan Augusto
     * @return String - Descricao do problema ou da manutenção que o veículo
     * necessita.
     */
    @Override
    public String getDescricao() {
        return this.descricao;
    }

    /**
     *
     * @author Luan Augusto
     * @param descricao String - Valor que será atualizado na descrição do
     * veículo.
     * @param atualizar boolean - Indica se a informação deve ser gravada no
     * banco de dados.
     */
    private void setDescricao(String descricao, boolean atualizar) {
        this.descricao = descricao;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Descricao` = ? )", new Object[]{this.getDescricao()});
        }
    }

    /**
     *
     * @author Luan Augusto
     * @return Principal - Objeto de controle principal.
     */
    private Principal getPrincipal() {
        return this.principal;
    }

    /**
     * Seta a instância do objeto principal na classe para que possa manipular o
     * banco de dados e/ou outras possíveis informações necessárias no objeto.
     *
     * @author Luan Augusto
     * @param principal Principal - Classe principal de gerenciamento.
     */
    private void setPrincipal(Principal principal) {
        this.principal = principal;
    }

}
