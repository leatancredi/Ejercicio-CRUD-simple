package datos;

import static datos.Conexion.*;
import domain.Usuario;
import java.sql.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioJDBC {

    private static final String SQL_SELECT = "SELECT idusuarios, username, password FROM usuarios";
    private static final String SQL_INSERT  = "INSERT INTO usuarios (username,password) VALUES(?,?)";
    private static final String SQL_UPDATE  = "UPDATE usuarios SET username = ?, password = ? WHERE idusuarios = ?";
    private static final String SQL_DELETE  = "DELETE FROM usuarios WHERE idusuarios = ?";
    public List<Usuario> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuarios = null;
        List<Usuario> Usuarios = new ArrayList<Usuario>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("idusuarios");
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                //CREAMOS OBJETOS DESDE LA BASE MEDIANTE EL CONTRUCTOR
                usuarios = new Usuario();
                usuarios.setIdusuario(idUsuario);
                usuarios.setUsername(username);
                usuarios.setPassword(password);

                Usuarios.add(usuarios);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                //CERRAMOS LOS OBJETOS
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return Usuarios;
    }
    public int insertar(Usuario usuarios){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuarios.getUsername());
            stmt.setString(2, usuarios.getPassword());
            
            //el metodo executeUpdate modifica el estado de la db, puede ejecturar update, delate e insert.
            registros = stmt.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
        }
        finally {
            try {
                //CERRAMOS LOS OBJETOS
                
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
          return registros;      
    }
            }
    public int actualizar(Usuario usuarios){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuarios.getUsername());
            stmt.setString(2, usuarios.getPassword());
            stmt.setInt(3, usuarios.getIdusuario());
            //el metodo executeUpdate modifica el estado de la db, puede ejecturar update, delate e insert.
            registros = stmt.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
        }
        finally {
            try {
                //CERRAMOS LOS OBJETOS
                
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
          return registros;      
    }
        }
    
        public int eliminar(Usuario usuarios){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuarios.getIdusuario());
            //el metodo executeUpdate modifica el estado de la db, puede ejecturar update, delate e insert.
            registros = stmt.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
        }
        finally {
            try {
                //CERRAMOS LOS OBJETOS
                
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
          return registros;      
    }
}
}