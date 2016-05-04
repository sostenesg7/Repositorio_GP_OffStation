package station.off.negocio.utils.carros;

import jdbchelper.QueryResult;
import station.off.Erros;
import station.off.Principal;
import station.off.negocio.interfaces.ICarro;
import station.off.negocio.utils.exceptions.InvalidTypeException;

public class Carro implements ICarro {

    private int id;
    private int ano;
    private String cor;
    private String placa;
    private String modelo;
    private String descricao;
    private Principal principal;

    public Carro(Principal principal, QueryResult resultado) throws InvalidTypeException {
        this.setPrincipal(principal);
        this.carregar(resultado);
    }

    @Override
    public void carregar(Object resultado) throws InvalidTypeException {
        if ((resultado instanceof QueryResult)) {
            QueryResult resultadoPronto = (QueryResult) resultado;
            this.setId(resultadoPronto.getInt("id"));
            this.setAno(resultadoPronto.getInt("Ano"), false);
            this.setDescricao(resultadoPronto.getString("Descricao"), false);
            this.setCor(resultadoPronto.getString("Cor"), false);
            this.setPlaca(resultadoPronto.getString("Placa"), false);
            this.setModelo(resultadoPronto.getString("Modelo"), false);
            resultadoPronto.close();
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
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public int getAno() {
        return this.ano;
    }

    private void setAno(int ano, boolean atualizar) {
        this.ano = ano;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Ano` = ? )", new Object[]{this.getAno()});
        }
    }

    @Override
    public String getCor() {
        return this.cor;
    }

    private void setCor(String cor, boolean atualizar) {
        this.cor = cor;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Cor` = ? )", new Object[]{this.getCor()});
        }
    }

    @Override
    public String getPlaca() {
        return this.placa;
    }

    private void setPlaca(String placa, boolean atualizar) {
        this.placa = placa;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Placa` = ? )", new Object[]{this.getPlaca()});
        }
    }

    @Override
    public String getModelo() {
        return this.modelo;
    }

    private void setModelo(String modelo, boolean atualizar) {
        this.modelo = modelo;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Modelo` = ? )", new Object[]{this.getModelo()});
        }
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    private void setDescricao(String descricao, boolean atualizar) {
        this.descricao = descricao;
        if ((atualizar)) {
            this.getPrincipal().getJdbc().run("UPDATE `carros` SET ( `Descricao` = ? )", new Object[]{this.getDescricao()});
        }
    }

    private Principal getPrincipal() {
        return this.principal;
    }

    private void setPrincipal(Principal principal) {
        this.principal = principal;
    }

}
