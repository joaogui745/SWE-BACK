
package prato;

import java.util.ArrayList;

public interface PratoDAO {
    public Prato buscarPorId(int idPrato);
    public void criar(Prato prato);
    public boolean apagar(int idPrato);
    public boolean atualizar(Prato prato, int idPrato);
    public ArrayList<Prato> buscarTodos();
}
