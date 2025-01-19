
package restaurante;

import avaliacao.Avaliacao;
import java.util.ArrayList;
import prato.Prato;

public interface RestauranteDAO{
    public Restaurante buscarPorId(int idRestaurante);
    public int criar(Restaurante restaurante);
    public boolean apagar(int idRestaurante);
    public boolean atualizar(Restaurante restaurante, int idrestaurante);
    public ArrayList<Restaurante> buscarTodos();
    public ArrayList<Prato> buscarPratos(int idRestaurante);
    public ArrayList<Avaliacao> buscarAvaliacoes(int idAvaliacao);
}
