package tryfood;


import modelos.Avaliacao;
import permanencia.sqlite.AvaliacaoDAOLite;
import permanencia.sqlite.UsuarioDAOLite;
import java.util.ArrayList;

public class TryFood {

    public static void main(String[] args) {
        AvaliacaoDAOLite userD = new AvaliacaoDAOLite();
        Avaliacao bad = new Avaliacao(1, 2, (float) 10.0, "uma bosta");
        int id = userD.criar(bad);
        System.out.println(id);
        System.out.println(userD.buscarPorId(id));
        bad.setConteudo("Moriscos lindos");
        userD.atualizar(bad, id);
        System.out.println(userD.buscarPorId(id));
        userD.apagar( id);
        for (Avaliacao user : userD.buscarTodos()){
            System.out.println(user);
        }
        
    }
}
