package modelos;

public abstract class Usuario {
    protected String nome, senha, email, dataCadastro;
    protected int idUsuario;
    
    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(String nome, String senha, String email, int idUsuario, String dataCadastro) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.idUsuario = idUsuario;
        this.dataCadastro = dataCadastro;
    }
    
    
    
    abstract public String getDocumento();
    
    @Override
    public String toString(){
        return String.format(
                """
                idUsuario: %s
                nome: %s
                senha: %s
                email: %s
                data: %s
                """, (this.idUsuario != 0 ? this.idUsuario : ""),nome, senha, email, dataCadastro);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
}
