package datos;

import java.sql.*;


public class Conexion {
    // CADENA CONEXION, NOTA : ES FINAL PORQUE ES UNA CONSTANTE
    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    //VARIABLE PARA EL USUARIO Y LA CONTRASEÑA
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
  
    //CREAMO EL METODO PARA LA CONEXION DE LA DB
    public static Connection getConnection() throws SQLException{
       return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    //CREAMOS LOS OBJETOS PARA CERRAR LA CONEXION
    public static void close(ResultSet rs) throws SQLException{
       rs.close(); 
    }
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
