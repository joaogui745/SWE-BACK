package permanencia.interfaces;

import modelos.Avaliacao;
import java.util.ArrayList;

public interface AvaliacaoDAO {
    public Avaliacao buscarPorId(int idPrato);
    public int criar(Avaliacao avaliacao);
    public boolean apagar(int idAvaliacao);
    public boolean atualizar(Avaliacao avaliacao, int idAvaliacao);
    public ArrayList<Avaliacao> buscarTodos();
}
