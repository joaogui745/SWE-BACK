package database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DataBase {
    private static DataBase dataBase = null;
    private Connection connection = null;

    private DataBase() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite::resource:" + DataBase.class.getResource("data.db"));
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            
            //statement.executeUpdate("drop table if exists person");
            //statement.executeUpdate("create table person (id integer, name string)");
            //statement.executeUpdate("insert into person values(3, 'shue')");
            statement.executeUpdate("insert into person values(6, 'vvro')");
            ResultSet rs = statement.executeQuery("select * from person");
          while(rs.next())
          {
            // read the result set
            System.out.println("name = " + rs.getString("name"));
            System.out.println("id = " + rs.getInt("id"));
          }
           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
    }
    
    public static DataBase getInstance(){
        if (dataBase == null){
            dataBase = new DataBase();
        }
        return dataBase;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    public void closeConnection() throws SQLException{
        this.connection.close();
    }
    
}
