package restaurante;

public class Restaurante {
    int idRestaurante, idUser;
    String nome, descricao, localizacao;
    boolean temEntrega;

    public Restaurante(int idUser, String nome, String descricao, String localizacao, boolean temEntrega) {
        this.idUser = idUser;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.temEntrega = temEntrega;
    }

    public Restaurante(int idRestaurante, int idUser, String nome, String descricao, String localizacao, boolean temEntrega) {
        this.idRestaurante = idRestaurante;
        this.idUser = idUser;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.temEntrega = temEntrega;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public boolean isTemEntrega() {
        return temEntrega;
    }

    public void setTemEntrega(boolean temEntrega) {
        this.temEntrega = temEntrega;
    }
    
    
}
