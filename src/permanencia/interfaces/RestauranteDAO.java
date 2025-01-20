
package permanencia.interfaces;

import modelos.Avaliacao;
import java.util.ArrayList;
import modelos.Prato;
import modelos.Restaurante;

public interface RestauranteDAO{
    public Restaurante buscarPorId(int idRestaurante);
    public int criar(Restaurante restaurante);
    public boolean apagar(int idRestaurante);
    public boolean atualizar(Restaurante restaurante, int idrestaurante);
    public ArrayList<Restaurante> buscarTodos();
    public ArrayList<Prato> buscarPratos(int idRestaurante);
    public ArrayList<Avaliacao> buscarAvaliacoes(int idAvaliacao);
}
