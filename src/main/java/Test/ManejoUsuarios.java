package Test;


import datos.UsuarioJDBC;
import domain.Usuario;
import java.util.List;
public class ManejoUsuarios {
    public static void main(String[] args) {
        UsuarioJDBC usuariosJdbc = new UsuarioJDBC();
        //ejecutamos la lista de usuarios
        List<Usuario> usuarios = usuariosJdbc.seleccionar();
        for(Usuario usuario: usuarios){
            System.out.println("usuario = " + usuario);
        }
        //insertando usuario
//        Usuario usuario = new Usuario("antonia","1234");
//        usuariosJdbc.insertar(usuario);

        //actualizar
//        Usuario usuario = new Usuario(3,"juana","12345");
//        usuariosJdbc.actualizar(usuario);
//    }
       //eliminar
      
//      usuariosJdbc.eliminar(new Usuario(3));
    
}}
