package tryfood;


import modelos.Avaliacao;
import permanencia.sqlite.AvaliacaoDAOLite;

public class TryFood {

    public static void main(String[] args) {
        // Acessa o banco
        AvaliacaoDAOLite acesso = new AvaliacaoDAOLite();
        
        // Cria o modelo
        Avaliacao avaliacaoRuim = new Avaliacao(1, 2, (float) 3.0, "Odiei");
        
        // CRUD's ao banco de dados
        int id = acesso.criar(avaliacaoRuim);
        System.out.println(id);
        System.out.println(acesso.buscarPorId(id));
        avaliacaoRuim.setConteudo("Moriscos aguados");
        acesso.atualizar(avaliacaoRuim, id);
        System.out.println(acesso.buscarPorId(id));
        acesso.apagar( id);
        for (Avaliacao user : acesso.buscarTodos()){
            System.out.println(user);
        }
        
    }
}
