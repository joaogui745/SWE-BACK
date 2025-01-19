package avaliacao;


public class Avaliacao{
   private int idAvaliacao, idRestaurante, idUsuario;
   private float nota;
   private String dataAvaliacao, conteudo;

    public Avaliacao(int idRestaurante, int idUsuario, float nota, String conteudo) {
        this.idRestaurante = idRestaurante;
        this.idUsuario = idUsuario;
        this.nota = nota;
        this.conteudo = conteudo;
    }

    public Avaliacao(int idAvaliacao, int idRestaurante, int idUsuario, float nota, String dataAvaliacao, String conteudo) {
        this.idAvaliacao = idAvaliacao;
        this.idRestaurante = idRestaurante;
        this.idUsuario = idUsuario;
        this.nota = nota;
        this.dataAvaliacao = dataAvaliacao;
        this.conteudo = conteudo;
    }
    
    @Override public String toString(){
        return String.format("""
                             idAvaliacao: %s
                             idRestaurante: %d
                             idUsuarios: %d
                             nota: %.2f
                             dataAvaliacao: %s
                             conteudo: %s
                             """, (idAvaliacao != 0 ? Integer.toString(idAvaliacao): ""), idRestaurante, idUsuario,
                             nota, dataAvaliacao, conteudo);
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
