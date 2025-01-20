
package prato;


import bancodedados.BancoDeDados;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class PratoDAOLite implements PratoDAO {
    Connection conexao;
    public PratoDAOLite() {
        conexao = BancoDeDados.getInstance().getConnection();
    }

    @Override
    public Prato buscarPorId(int idPrato) {
        int idRestaurante;
        String nome, descricao, imagem;
        float preco;
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "select * from prato where idPrato = ?")) {
        comando.setInt(1, idPrato);
        ResultSet res  = comando.executeQuery();
        if (res.next()){
            idRestaurante = res.getInt("idRestaurante");
            nome = res.getString("nome");
            descricao = res.getString("descricao");
            imagem = res.getString("imagem");
            preco = res.getFloat("preco");
            return new Prato(idPrato, idRestaurante, nome, descricao, imagem, preco);
        }
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        return null;
    }

    @Override
    public int criar(Prato prato) {
        int resultado = 0;
        try (PreparedStatement comando = conexao.prepareStatement(
                "INSERT INTO prato(nome, descricao, preco, imagem, idRestaurante) VALUES(?, ?, ?, ?, ?)"
                        + "RETURNING idPrato;")) {
            comando.setString(1, prato.getNome());
            comando.setString(2, prato.getDescricao());
            comando.setFloat(3, prato.getPreco());
            comando.setString(4, prato.getImagem());
            comando.setInt(5, prato.getIdRestaurante());
            ResultSet id = comando.executeQuery();
            resultado = id.getInt("idPrato");
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }

    @Override
    public boolean apagar(int idPrato) {
        int resposta = 0;
        try (PreparedStatement comando = conexao.prepareStatement(
                    "DELETE FROM prato WHERE idPrato = ?;")) {
            comando.setInt(1, idPrato);
            resposta  = comando.executeUpdate();
        }catch (SQLException ex) {
                System.out.println(ex);
        }
        return resposta == 1;
    }

    @Override
    public boolean atualizar(Prato prato, int idPrato) {
        int res = 0;
        try (PreparedStatement comando = conexao.prepareStatement(
  """
              UPDATE prato
              SET idRestaurante = ?, nome = ?,
              descricao = ? , imagem = ?, preco = ?
              WHERE idPrato = ?; 
        """)) {
            comando.setInt(1, prato.getIdRestaurante());
            comando.setString(2, prato.getNome());
            comando.setString(3, prato.getDescricao());
            comando.setString(4, prato.getImagem());
            comando.setFloat(5, prato.getPreco());
            comando.setInt(6, idPrato);
            res  = comando.executeUpdate();
        }
        catch (SQLException ex) {
                System.out.println(ex);
        }
        return res == 1;
    }

    @Override
    public ArrayList<Prato> buscarTodos() {
        int idRestaurante, idPrato;
        String nome, descricao, imagem;
        float preco;
        ArrayList<Prato> lista = new ArrayList<>();
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "select * from prato")) {
        ResultSet res  = comando.executeQuery();
        conexao.close();
        while (res.next()){
            idPrato = res.getInt("idPrato");
            idRestaurante = res.getInt("idRestaurante");
            nome = res.getString("nome");
            descricao = res.getString("descricao");
            imagem = res.getString("imagem");
            preco = res.getFloat("preco");
            lista.add(new Prato(idPrato, idRestaurante, nome, descricao, imagem, preco));
        }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        return lista;
    }
    
}
