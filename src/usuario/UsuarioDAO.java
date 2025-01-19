package usuario;

import java.util.ArrayList;

public interface UsuarioDAO {
    public Usuario buscarPorId(int idUsuario);
    public boolean criar(Usuario usuario);
    public boolean apagar(int idUsuario);
    public boolean atualizar(Usuario usuario, int idUsuario);
    public ArrayList<Usuario> buscarTodos();
}
