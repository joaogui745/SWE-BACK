package tryfood;


import usuario.Pessoa;
import usuario.Usuario;
import usuario.UsuarioDAOLite;
public class TryFood {

    public static void main(String[] args) {
        Pessoa user = new Pessoa("222", "John uptow", "huebr", "cic@br.com");
        //System.out.println(user);
        UsuarioDAOLite userD = new UsuarioDAOLite();
        //boolean criar = userD.criar(user);
        
        for (Usuario usu : userD.buscarTodos()){
            System.out.println(usu);
        }
    }
}
