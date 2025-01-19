package usuario;


public class Pessoa extends Usuario {
    private String cpf;

    public Pessoa(String cpf, String nome, String senha, String email) {
        super(nome, senha, email);
        this.cpf = cpf;
    }

    public Pessoa(String cpf, String nome, String senha, String email, int idUsuario, String dataCadastro) {
        super(nome, senha, email, idUsuario, dataCadastro);
        this.cpf = cpf;
    }
    
    
    
    @Override
    public String getDocumento(){
        return this.cpf;
    }
    
    @Override
    public String toString(){
        return super.toString() + "CPF: " + this.cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
}
