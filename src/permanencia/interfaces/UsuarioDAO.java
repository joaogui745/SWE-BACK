package permanencia.interfaces;

import modelos.Avaliacao;
import java.util.ArrayList;
import modelos.Restaurante;
import modelos.Usuario;

public interface UsuarioDAO {
    public Usuario buscarPorId(int idUsuario);
    public int criar(Usuario usuario);
    public boolean apagar(int idUsuario);
    public boolean atualizar(Usuario usuario, int idUsuario);
    public ArrayList<Usuario> buscarTodos();
    public ArrayList<Restaurante> buscarRestaurantes(int udUsuario);
    public ArrayList<Avaliacao> buscarAvaliacoes(int idAvaliacoes);
    public Usuario buscarPorEmail(String userEmail);
    public Usuario criarRet(Usuario usuario);
}
