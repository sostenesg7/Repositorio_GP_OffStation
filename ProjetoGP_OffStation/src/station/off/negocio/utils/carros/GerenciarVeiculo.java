package station.off.negocio.utils.carros;

import java.util.Map;
import jdbchelper.JdbcException;
import jdbchelper.QueryResult;
import station.off.Erros;
import station.off.Principal;
import station.off.negocio.interfaces.IVeiculo;
import station.off.negocio.utils.exceptions.InvalidTypeException;

public final class GerenciarVeiculo {

    public GerenciarVeiculo() {
        throw Erros.INSTANCIA_INVALIDA;
    }

    /**
     *
     * @author Luan Augusto
     * @param principal Principal - Classe de gerenciamento principal.
     * @param informacao Map<String, Object> - Informacoes que serao salvas no
     * banco de dados.
     */
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

    /**
     *
     * @author Luan Augusto
     * @param principal Principal - Classe de gerenciamento principal.
     * @param id int - ID que será procurado no banco de dados.
     * @return IVeiculo - Objeto carregado com as informações do banco de dados.
     * @throws InvalidTypeException - Caso ocorra erro na construção do Objeto
     * do veículo.
     */
    public static IVeiculo pegar(Principal principal, int id) throws InvalidTypeException {
        QueryResult resultado = principal.getJdbc().query("SELECT * FROM `carros` WHERE ( `id` = ? )", new Object[]{id});

        if ((resultado.next())) {
            return new Veiculo(principal, resultado);
        }

        return null;
    }

}
