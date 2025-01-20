package permanencia.interfaces;

import java.util.ArrayList;
import modelos.Prato;

public interface PratoDAO{
    public Prato buscarPorId(int idPrato);
    public int criar(Prato prato);
    public boolean apagar(int idPrato);
    public boolean atualizar(Prato prato, int idPrato);
    public ArrayList<Prato> buscarTodos();
}
