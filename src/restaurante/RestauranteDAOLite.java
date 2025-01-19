package restaurante;

import avaliacao.Avaliacao;
import bancodedados.BancoDeDados;
import prato.Prato;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class RestauranteDAOLite implements RestauranteDAO{
    private final Connection conexao;
    
    public RestauranteDAOLite() {
        this.conexao = BancoDeDados.getInstance().getConnection();
    }
    
    @Override
    public Restaurante buscarPorId(int idRestaurante){
        String  nome, descricao, localizacao;
        boolean temEntrega;
        int idUsuario;
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "select * from restaurante where idRestaurante = ?")) {
        comando.setInt(1, idRestaurante);
        ResultSet res  = comando.executeQuery();
        if (res.next()){
            nome = res.getString("nome");
            descricao = res.getString("descricao");
            localizacao = res.getString("localizacao");
            temEntrega = res.getBoolean("temEntrega");
            idUsuario = res.getInt("idUser");
            return new Restaurante(idRestaurante, idUsuario, nome, descricao, localizacao, temEntrega);
        }
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        return null;
    }

    @Override
    public boolean criar(Restaurante restaurante) {
        try (PreparedStatement comando = conexao.prepareStatement(
                "INSERT INTO restaurante(nome, descricao, temEntrega, localizacao, idUser) VALUES(?, ?, ?, ?, ?);")) {
            comando.setString(1, restaurante.getNome());
            comando.setString(2, restaurante.getDescricao());
            comando.setInt(3, restaurante.isTemEntrega() ? 1 : 0);
            comando.setString(4, restaurante.getLocalizacao());
            comando.setInt(5, restaurante.getIdUser());
            comando.execute();
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return true;
    }

    @Override
    public boolean apagar(int idRestaurante) {
        try (PreparedStatement comando = conexao.prepareStatement(
                    "DELETE FROM restaurante WHERE idRestaurante = ?;")) {
            comando.setInt(1, idRestaurante);
            int res  = comando.executeUpdate();
            return res == 1;
        }catch (SQLException ex) {
                System.out.println(ex);
        }
        return false;
    }
    

    @Override
    public boolean atualizar(Restaurante restaurante, int idRestaurante) {
        try (PreparedStatement comando = conexao.prepareStatement(
  """
              UPDATE restaurante
              SET idUser = ?, nome = ?,
              descricao = ? , localizacao = ?, temEntrega = ?
              WHERE idRestaurante = ?; 
        """)) {
            comando.setInt(1, restaurante.getIdUser());
            comando.setString(2, restaurante.getNome());
            comando.setString(3, restaurante.getDescricao());
            comando.setString(4, restaurante.getLocalizacao());
            comando.setInt(5, restaurante.isTemEntrega() ? 1 : 0);
            comando.setInt(6, idRestaurante);
            int res  = comando.executeUpdate();
            return res == 1;
        }
        catch (SQLException ex) {
                System.out.println(ex);
        }
        return false;
    }

    @Override
    public ArrayList<Restaurante> buscarTodos() {
        String nome, descricao, localizacao;
        boolean temEntrega;
        int idUsuario, idRestaurante;
        ArrayList<Restaurante> lista = new ArrayList<>();
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "select * from restaurante")) {
        ResultSet res  = comando.executeQuery();
        while (res.next()){
            nome = res.getString("nome");
            descricao = res.getString("descricao");
            localizacao = res.getString("localizacao");
            temEntrega = res.getInt("temEntrega") == 1;
            idUsuario = res.getInt("idUser");
            idRestaurante = res.getInt("idRestaurante");
            lista.add(new Restaurante(idRestaurante,idUsuario, nome, descricao, localizacao, temEntrega));
        }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        return lista;
    }
    
    @Override
    public ArrayList<Prato> buscarPratos(int idRestaurante){
        int idPrato;
        String nome, descricao, imagem;
        float preco;
        ArrayList<Prato> lista = new ArrayList<>();
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "SELECT * FROM prato WHERE idRestaurante = ?")) {
        comando.setInt(0, idRestaurante);
        ResultSet res  = comando.executeQuery();
        while (res.next()){
            idPrato = res.getInt("idPrato");
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
    
    @Override
    public ArrayList<Avaliacao> buscarAvaliacoes(int idRestaurante) {
        int idAvaliacao, idUsuario;
        float nota;
        String dataAvaliacao, conteudo;
        
        ArrayList<Avaliacao> lista = new ArrayList<>();
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "SELECT * FROM avaliacao WHERE idRestaurante = ?")) {
        comando.setInt(0, idRestaurante);
        ResultSet res  = comando.executeQuery();
        while (res.next()){
            idAvaliacao = res.getInt("idAvaliacao");
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
