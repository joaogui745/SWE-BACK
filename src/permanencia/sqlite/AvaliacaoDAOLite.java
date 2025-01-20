package permanencia.sqlite;

import permanencia.interfaces.AvaliacaoDAO;
import modelos.Avaliacao;
import bancodedados.BancoDeDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import java.util.ArrayList;

public class AvaliacaoDAOLite implements AvaliacaoDAO {
    Connection conexao;
    public AvaliacaoDAOLite() {
        conexao = BancoDeDados.getInstance().getConnection();
    }

    @Override
    public Avaliacao buscarPorId(int idAvaliacao) {
        int idRestaurante, idUsuario;
        float nota;
        String dataAvaliacao, conteudo;
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "select * from avaliacao where idAvaliacao = ?")) {
        comando.setInt(1, idAvaliacao);
        ResultSet res  = comando.executeQuery();
        
        if (res.next()){
            idRestaurante = res.getInt("idRestaurante");
            idUsuario = res.getInt("idUsuario");
            nota = res.getFloat("nota");
            dataAvaliacao = res.getString("dataAvaliacao");
            conteudo = res.getString("conteudo");
            return new Avaliacao(idAvaliacao, idRestaurante, idUsuario, nota, dataAvaliacao, conteudo);
        }
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public int criar(Avaliacao avaliacao) {
        int resultado = 0;
        try (PreparedStatement comando = conexao.prepareStatement(
                "INSERT INTO avaliacao(idRestaurante, idUsuario, nota, conteudo) VALUES(?, ?, ?, ?)"
                        + "RETURNING idAvaliacao;")) {
            comando.setInt(1, avaliacao.getIdRestaurante());
            comando.setInt(2, avaliacao.getIdUsuario());
            comando.setFloat(3, avaliacao.getNota());
            comando.setString(4, avaliacao.getConteudo());
            ResultSet id = comando.executeQuery();
            resultado = id.getInt("idAvaliacao");
            
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    @Override
    public boolean apagar(int idAvaliacao) {
        int resultado = 0;
        try (PreparedStatement comando = conexao.prepareStatement(
                    "DELETE FROM avaliacao WHERE idAvaliacao = ?;")) {
            comando.setInt(1, idAvaliacao);
            resultado  = comando.executeUpdate();
            
        }catch (SQLException ex) {
                System.out.println(ex);
        }
        return 1 == resultado;
    }

    @Override
    public boolean atualizar(Avaliacao avaliacao, int idAvaliacao) {
        int resultado = 0;
        try (PreparedStatement comando = conexao.prepareStatement(
  """
              UPDATE avaliacao
              SET idRestaurante = ?, idUsuario = ?,
              nota = ? , conteudo = ?
              WHERE idAvaliacao = ?; 
        """)) {
            comando.setInt(1, avaliacao.getIdRestaurante());
            comando.setInt(2, avaliacao.getIdUsuario());
            comando.setFloat(3, avaliacao.getNota());
            comando.setString(4, avaliacao.getConteudo());
            comando.setInt(5, idAvaliacao);
            resultado  = comando.executeUpdate();
            
        }
        catch (SQLException ex) {
                System.out.println(ex);
        }
        return resultado == 1;
    }

    @Override
    public ArrayList<Avaliacao> buscarTodos() {
        int idRestaurante, idUsuario, idAvaliacao;
        float nota;
        String dataAvaliacao, conteudo;
        
        ArrayList<Avaliacao> lista = new ArrayList<>();
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "select * from avaliacao")) {
        ResultSet res  = comando.executeQuery();
        
        while (res.next()){
            idAvaliacao = res.getInt("idAvaliacao");
            idRestaurante = res.getInt("idRestaurante");
            idUsuario = res.getInt("idUsuario");
            nota = res.getFloat("nota");
            dataAvaliacao = res.getString("dataAvaliacao");
            conteudo = res.getString("conteudo");
            lista.add(new Avaliacao(idAvaliacao, idRestaurante, idUsuario, nota, dataAvaliacao, conteudo));
        }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        return lista;
    }
    
    
}
