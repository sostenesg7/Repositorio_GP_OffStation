package projetos.gerencia.apresentacao;

import projetos.gerencia.negocio.cliente.Cliente;
import projetos.gerencia.negocio.cliente.ICliente;
import projetos.gerencia.persistencia.cliente.PersistirCliente;

public final class ControlarCliente {

    private ICliente cliente;

    /*
     Invés de passar parametro por parametro, seria mais interessante passar o objeto que vai
     controlar o formulário, assim poderíamos utilizar por exemplo: "objeto.getInput().getText()"
    
     Não é obrigado fazer isso, pode deixar dessa forma se preferir, mas, passando diretamente
     o objeto seria mais interessante... caso futuramente mudarmos os atributos não precisar ficar
     mudando um cento de métodos, isso também vai aplicar pros carros e qualquer outro objeto
     que precisar ser persistido no banco de dados, enfim, acho que vc entendeu.
     */
    public ControlarCliente(String nome, String sobrenome, String email) {
        Cliente novoCliente = new Cliente(nome, sobrenome, email);
        this.setCliente(novoCliente);
    }

    public boolean salvar() {
        return PersistirCliente.getInstancia().salvar(this.getCliente());
    }

    public ICliente getCliente() {
        return this.cliente;
    }

    private void setCliente(ICliente cliente) {
        this.cliente = cliente;
    }

}
