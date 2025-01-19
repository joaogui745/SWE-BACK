
package avaliacao;

import java.util.ArrayList;

public interface AvaliacaoDAO {
    public Avaliacao buscarPorId(int idPrato);
    public void criar(Avaliacao avaliacao);
    public boolean apagar(int idAvaliacao);
    public boolean atualizar(Avaliacao avaliacao, int idAvaliacao);
    public ArrayList<Avaliacao> buscarTodos(); 
}
