//Santiago Usaquen Vargas 20201578087
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexionMySQL {
  
    private static ConexionMySQL instance;
    private Connection cnn;
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";      
    private String pss = "";      
    private String nom_bd = "bd1_tallerjavaweb";
    private String url = "jdbc:mysql://localhost:3306/";   
    
    private ConexionMySQL(){
        try {
            Class.forName(driver);
            cnn = DriverManager.getConnection(url + nom_bd, user, pss);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.print("error en driver mysql"+ex.getMessage());
        }
        
    }
    
    public static synchronized ConexionMySQL getInstance(){
        if(instance == null){
            instance = new ConexionMySQL(); 
        }
        return instance;
    }
    
    
    public Connection getCnn(){
        return cnn;
    }
    
    public void cerrarconexion(){
//        if(cnn != null){
//            try {
//                cnn.close();
//            } catch (SQLException ex) {
//                System.out.print("error al cerrar la conexion: "+ex.getMessage());
//            }
            instance = null;
    }   
    }
       
    

