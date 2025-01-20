package modelos;

public class Empresa extends Usuario {
    private String cnpj;

    public Empresa(String cnpj, String nome, String senha, String email) {
        super(nome, senha, email);
        this.cnpj = cnpj;
    }

    public Empresa(String cnpj, String nome, String senha, String email, int idUsuario, String dataCadastro) {
        super(nome, senha, email, idUsuario, dataCadastro);
        this.cnpj = cnpj;
    }
    
    
    
    @Override
    public String getDocumento(){
        return this.cnpj;
    }
    
    @Override
    public String toString(){
        return super.toString() + "CNPJ: " + this.cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
        
}
