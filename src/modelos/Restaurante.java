package modelos;

public class Restaurante {
    int idRestaurante, idUsuario;
    String nome, descricao, localizacao;
    boolean temEntrega;

    public Restaurante(int idUsuario, String nome, String descricao, String localizacao, boolean temEntrega) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.temEntrega = temEntrega;
    }

    public Restaurante(int idRestaurante, int idUsuario, String nome, String descricao, String localizacao, boolean temEntrega) {
        this.idRestaurante = idRestaurante;
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.temEntrega = temEntrega;
    }

    @Override
    public String toString() {
        return String.format("""
                             idRestaurante: %s
                             idUsuario: %s
                             nome: %s
                             descricao: %s
                             localizacao: %s
                             temEntrega: %S
                             """, (idRestaurante != 0 ? Integer.toString(idRestaurante): ""), idUsuario, nome, descricao, localizacao,
                             (temEntrega ? "SIM" : "Nao"));
    }
    
    

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdUser() {
        return idUsuario;
    }

    public void setIdUser(int idUsuario) {
        this.idUsuario = idUsuario;
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
