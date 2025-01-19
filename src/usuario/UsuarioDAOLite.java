package usuario;

import avaliacao.Avaliacao;
import bancodedados.BancoDeDados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import restaurante.Restaurante;


public class UsuarioDAOLite implements UsuarioDAO{
    Connection conexao;
    public UsuarioDAOLite() {
        conexao = BancoDeDados.getInstance().getConnection();
    }
    
    @Override
    public boolean apagar(int idUsuario){
        try (PreparedStatement comando = conexao.prepareStatement(
                    "DELETE FROM usuario WHERE idUsuario = ?;")) {
            comando.setInt(1, idUsuario);
            int res  = comando.executeUpdate();
            return res == 1;
        }catch (SQLException ex) {
                System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public Usuario buscarPorId(int idUsuario){
        String documento, nome, senha, email;
        String dataCadastro;
        try (PreparedStatement comando = conexao.prepareStatement(
                "select * from usuario where idUsuario = ?")) {
        comando.setInt(1, idUsuario);
        ResultSet res  = comando.executeQuery();
        if (res.next()){
            nome = res.getString("nome");
            senha = res.getString("senha");
            email = res.getString("email");
            documento = res.getString("documento");
            dataCadastro = res.getString("dataCadastro");
            if (res.getString("tipoDocumento").equals("cpf")){
                return new Pessoa(documento, nome, senha, email,idUsuario, dataCadastro);
            }
            return new Empresa(documento, nome, senha, email, idUsuario, dataCadastro);
        }
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        return null;
    }
    
    @Override
    public Usuario buscarPorEmail(String userEmail){
        String documento, nome, senha, email, dataCadastro;
        int idUsuario;
        try (PreparedStatement comando = conexao.prepareStatement(
                "select * from usuario where email = ?")) {
        comando.setString(1, userEmail);
        ResultSet res  = comando.executeQuery();
        if (res.next()){
            nome = res.getString("nome");
            senha = res.getString("senha");
            email = res.getString("email");
            documento = res.getString("documento");
            dataCadastro = res.getString("dataCadastro");
            idUsuario = res.getInt("idUsuario");
            if (res.getString("tipoDocumento").equals("cpf")){
                return new Pessoa(documento, nome, senha, email, idUsuario, dataCadastro);
            }
            return new Empresa(documento, nome, senha, email, idUsuario, dataCadastro);
        }
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        return null;
    }
    
    @Override
    public int criar(Usuario usuario) {
        int resultado = 0;
        if (buscarPorEmail(usuario.getEmail()) != null){
            return resultado;
        }
        try (PreparedStatement comando = conexao.prepareStatement(
                "INSERT INTO usuario(nome, senha, email, documento, tipoDocumento) VALUES(?, ?, ?, ?, ?)"
                        + "RETURNING idUsuario;")) {
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getDocumento());
            comando.setString(5, usuario instanceof Pessoa ? "cpf" : "cnpj");
            ResultSet id = comando.executeQuery();
            resultado = id.getInt("idUsuario");
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return resultado;
    }
    
    @Override
    public Usuario criarRet(Usuario usuario) {
        String documento, nome, senha, email, dataCadastro;
        int idUsuario;
        if (buscarPorEmail(usuario.getEmail()) != null){
            return null;
        }
        try (PreparedStatement comando = conexao.prepareStatement(
                "INSERT INTO usuario(nome, senha, email, documento, tipoDocumento) "
                + "VALUES(?, ?, ?, ?, ?) RETURNING *;")) {
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getDocumento());
            comando.setString(5, usuario instanceof Pessoa ? "cpf" : "cnpj");
            ResultSet ret = comando.executeQuery();
            if (ret.next()){
            nome = ret.getString("nome");
            senha = ret.getString("senha");
            email = ret.getString("email");
            documento = ret.getString("documento");
            dataCadastro = ret.getString("dataCadastro");
            idUsuario = ret.getInt("idUsuario");
            if (ret.getString("tipoDocumento").equals("cpf")){
                return new Pessoa(documento, nome, senha, email,idUsuario, dataCadastro);
            }
                return new Empresa(documento, nome, senha, email, idUsuario, dataCadastro);
            }
            
        } 
        catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    @Override
    public boolean atualizar(Usuario usuario, int idUsuario){
        try(PreparedStatement restricao = conexao.prepareStatement(
                "SELECT * FROM usuario WHERE idUsuario != ? AND email = ?")) {
            restricao.setInt(1, idUsuario);
            restricao.setString(2, usuario.getEmail());
            ResultSet resultado = restricao.executeQuery();
            if (resultado.next()){
                return false;
            }
        try (PreparedStatement comando = conexao.prepareStatement(
  """
              UPDATE usuario
              SET nome = ?, senha = ?, email = ?,
              documento = ? , tipoDocumento = ?
              WHERE idUsuario = ?; 
        """)) {
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getSenha());
            comando.setString(3, usuario.getEmail());
            comando.setString(4, usuario.getDocumento());
            comando.setString(5, usuario instanceof Pessoa ? "cpf" : "cnpj");
            comando.setInt(6, idUsuario);
            int res  = comando.executeUpdate();
            return res == 1;
        }}
        catch (SQLException ex) {
                System.out.println(ex);
        }
        return false;
    }
    
    @Override
    public ArrayList<Usuario> buscarTodos(){
        String documento, nome, senha, email, dataCadastro;
        int idUsuario;
        ArrayList<Usuario> lista = new ArrayList<>();
        try (PreparedStatement comando = conexao.prepareStatement(
                "select * from usuario")) {
        ResultSet res  = comando.executeQuery();
        while (res.next()){
            nome = res.getString("nome");
            senha = res.getString("senha");
            email = res.getString("email");
            documento = res.getString("documento");
            idUsuario = res.getInt("idUsuario");
            dataCadastro = res.getString("dataCadastro");
            if (res.getString("tipoDocumento").equals("cpf")){
                lista.add(new Pessoa(documento, nome, senha, email, idUsuario, dataCadastro));
            }
            else{
                lista.add(new Empresa(documento, nome, senha, email, idUsuario, dataCadastro));
            }
        }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        } 
        return lista;
    }
    
    @Override
    public ArrayList<Restaurante> buscarRestaurantes(int idUsuario){
        String nome, descricao, localizacao;
        boolean temEntrega;
        int idRestaurante;
        ArrayList<Restaurante> lista = new ArrayList<>();
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "SELECT * FROM restaurante WHERE idUsuario = ?")) {
        comando.setInt(1, idUsuario);
        ResultSet res  = comando.executeQuery();
        while (res.next()){
            nome = res.getString("nome");
            descricao = res.getString("descricao");
            localizacao = res.getString("localizacao");
            temEntrega = res.getInt("temEntrega") == 1;
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
    public ArrayList<Avaliacao> buscarAvaliacoes(int idUsuario) {
        int idAvaliacao, idRestaurante;
        float nota;
        String dataAvaliacao, conteudo;
        
        ArrayList<Avaliacao> lista = new ArrayList<>();
        
        try (PreparedStatement comando = conexao.prepareStatement(
                "SELECT * FROM avaliacao WHERE idUsuario = ?")) {
        comando.setInt(1, idUsuario);
        ResultSet res  = comando.executeQuery();
        while (res.next()){
            idAvaliacao = res.getInt("idAvaliacao");
            idRestaurante = res.getInt("idRestaurante");
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
