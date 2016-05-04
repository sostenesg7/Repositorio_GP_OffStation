package station.off.negocio.utils.carros;

import java.util.Map;
import jdbchelper.JdbcException;
import jdbchelper.QueryResult;
import station.off.Erros;
import station.off.Principal;
import station.off.negocio.interfaces.ICarro;
import station.off.negocio.utils.exceptions.InvalidTypeException;

public final class GerenciarCarro {

    public GerenciarCarro() {
        throw Erros.INSTANCIA_INVALIDA;
    }

    public static void criar(Principal principal, Map<String, Object> informacao) {
        if ((informacao != null)) {
            try {
                principal.getJdbc().beginTransaction();
                principal.getJdbc().run("INSERT INTO `carros` (`DonoID`, `Ano`, `Modelo`, `Cor`, `Placa`, `Descricao`) VALUES ( ?, ?, ?, ?, ?, ? )", new Object[]{1, informacao.get("Ano"), informacao.get("Modelo"), informacao.get("Cor"), informacao.get("Placa"), informacao.get("Descricao")});
            } catch (JdbcException error) {
                if ((principal.getJdbc().isInTransaction())) {
                    principal.getJdbc().rollbackTransaction();
                }
            } finally {
                if ((principal.getJdbc().isInTransaction())) {
                    principal.getJdbc().commitTransaction();
                    System.out.println("Veiculo '" + informacao.get("Modelo") + "' de placa: '" + informacao.get("Placa") + "' cadastrado no sistema.");
                }
            }
        } else {
            NullPointerException error = new NullPointerException("Parametro 'informacao' nao pode ser nulo");
            throw error;
        }
    }

    public static ICarro pegar(Principal principal, int id) throws InvalidTypeException {
        QueryResult resultado = principal.getJdbc().query("SELECT * FROM `carros` WHERE ( `id` = ? )", new Object[]{id});
        
        if ((resultado.next())) {
            return new Carro(principal, resultado);
        }

        return null;
    }

}
