package Test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
      
        //insertando un nuevo objeto tipo persona
//        Persona personaNueva = new Persona("eduardo","leon","edu@leon.com","1144824419");
        //reutilizamos el objeto
//        personaDao.insertar(personaNueva);
        //PARA ACTUALIZAR
//        Persona personaModificar = new Persona(4, "Martin","Tancredi","Martin@tancredi","44824419");
//        personaDao.actualizar(personaModificar);
        //PARA ELIMINAR
        Persona personaEliminar = new Persona(7);
        personaDao.eliminar(personaEliminar);
        List<Persona> personas = personaDao.seleccionar();
        //FUNCION FLECHA
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
