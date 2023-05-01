package BaseDatos;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    //1. Debo crear un metodo de conexion.
    //2. Debo conectar mi archivo "CuerpoDeAgua.db".
    //3. Debo verificar la conexion.
    
    //Crear una url hacia mi CuerpoDeAgua.db
    //metodo conectar
    Connection connection = null;
    
    public String obtener_url(){
        String sjdbc = "jdbc:sqlite";
        Path path = Paths.get("src/BaseDatos/CuerpoDeAgua.db");
        String url = sjdbc + ":\\" + path.toAbsolutePath();

        return url;
    }
    
    public void conectar() throws SQLException{
        try{
            connection = DriverManager.getConnection(obtener_url());
          if ( connection != null ){
             System.out.println("Conexión exitosa!");
          }
        }
        catch ( Exception ex ) {
          System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
          System.out.println("Error en la conexión");
        }   
        try{
            connection.close();
        }catch ( Exception ex ) {
            System.out.println("Error en la conexión");
        }
    }
    
    public void Agregar(String Query) throws SQLException{  
        try{
            connection = DriverManager.getConnection(obtener_url());
          if ( connection != null ){
             connection.prepareStatement(Query).executeUpdate();
             //Para INSERT, UPDATE or DELETE usar el metodo executeUpdate() y para SELECT usar el metodo executeQuery() que retorna un ResultSet.
             System.out.println("Conexión exitosa!");
          }
        }
        catch ( Exception ex ) {
          System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
          System.out.println("Error en la conexión");
        }
        try{
            connection.close();
        }catch ( Exception ex ) {
            System.out.println("Error en la conexión");
        }
    }

    public ResultSet consultar(String Query) throws SQLException{  
        try{
          connection = DriverManager.getConnection(obtener_url());
          if ( connection != null ){
             ResultSet resultado = connection.prepareStatement(Query).executeQuery();
             //Para INSERT, UPDATE or DELETE usar el metodo executeUpdate() y para SELECT usar el metodo executeQuery() que retorna un ResultSet.
             System.out.println("Conexión exitosa!");
             return resultado;
          }
        }
        catch ( Exception ex ) {
          System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
          System.out.println("Error en la conexión");
        }
        try{
            connection.close();
        }catch ( Exception ex ) {
            System.out.println("Error en la conexión");
        }
        return null;
    }
    
    public void cerrar(ResultSet resultado) throws SQLException{
        resultado.close();
    }
    

}
