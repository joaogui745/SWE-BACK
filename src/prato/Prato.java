
package prato;

public class Prato {
    int idPrato, idRestaurante;
    private String nome, descricao, imagem;
    float preco;

    public Prato(int idRestaurante, String nome, String descricao, String imagem, float preco) {
        this.idRestaurante = idRestaurante;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
    }

    public Prato(int idPrato, int idRestaurante, String nome, String descricao, String imagem, float preco) {
        this.idPrato = idPrato;
        this.idRestaurante = idRestaurante;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
    }
    
    @Override 
    public String toString(){
       return String.format("""
              idPrato: %s
              idRestaurante: %d
              nome: %s
              descricao: %s
              imagem: %s
              preco: %.2f
              """, idPrato != 0 ? Integer.toString(idPrato) : "", idRestaurante, nome, descricao, imagem, preco);
    }

    public int getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(int idPrato) {
        this.idPrato = idPrato;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    
}
