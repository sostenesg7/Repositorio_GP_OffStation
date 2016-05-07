package projetos.gerencia.negocio.cliente;

public final class Cliente implements ICliente {

    private int id;
    private String nome;
    private String sobrenome;
    private String email;

    public Cliente(String nome, String sobrenome, String email) {
        this(0, nome, sobrenome, email);
    }

    public Cliente(int id, String nome, String sobrenome, String email) {
        this.setId(id);
        this.setNome(nome);
        this.setSobrenome(sobrenome);
        this.setEmail(email);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    private void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
