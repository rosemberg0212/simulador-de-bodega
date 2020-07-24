
package Clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Validar {
    
    public static HashMap<String, Datos> listaDeUsuarios;
     public static HashMap<String, Inventario> listaDeObjetos;
    Archivos archi = new Archivos();
    public Validar(){
        if(listaDeUsuarios == null)
        {
            listaDeUsuarios = new HashMap<String, Datos>();
        }
        if(listaDeObjetos == null)
        {
            listaDeObjetos = new HashMap<String, Inventario>();
        }
    }
    public void agregarUsuario(Datos usuario) throws IOException
    {
        
        if(usuario != null)
        {
            listaDeUsuarios.put(usuario.getUsuario(), usuario);
           Archivos.guardarUsuarios();
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puede agregar un usuario sin datos");
        }
    }
    
     public Datos validarUsuario(String contra) throws Exception
    {
        Datos miObjeto=null;
        
        Archivos.recuperarLista();
        if(listaDeUsuarios.containsKey(contra)==true)
        {
            miObjeto= listaDeUsuarios.get(contra);
            
        }
        else
        {
            throw new Exception("Error");
        }
        return miObjeto;
    }  
     //este metodo permite agreagr Objetos a lalista de inventario
    //la clave para ingresar es el numero del iten siempre y cuando esta no este vacia
    public void agregarObjeto(Inventario miObjeto) throws Exception
    {
        if(miObjeto != null)
        {
            listaDeObjetos.put(miObjeto.getItem(), miObjeto);
            Archivos.guardarObjetos();
        }
        else
        {
            throw new Exception("No se puede agregar un Objeto sin datos");
        }
    }
    //este metodo permite editar los datos del Objeto dentro de la lista
    //siempre y cuando este esté dentro de la lista, o sea la clave del objeto
    //debe ser igual al iten a modificar
    public void EditObjeto(Inventario miObjeto) throws Exception
    {
        if(listaDeObjetos == null || listaDeObjetos.isEmpty())
        {
            throw new Exception("No se puede realizar la operacion por"
                    + " que el sistema tiene 0 Objetos en su BD");
        }
        else
        {
            String item = miObjeto.getItem();
            if(listaDeObjetos.containsKey(item)==true)
            {
                listaDeObjetos.put(item, miObjeto);
                Archivos.guardarObjetos();
            }
            else
            {
                throw new Exception("El objeto a editar no se encuentra en el sistema");
            }
        }
    }
    //metodo para eliminar Objeto de la lista de inventario
    public void eliminarObjeto(String item) throws Exception
    {
        if(listaDeObjetos.containsKey(item)==true)
        {
            listaDeObjetos.remove(item);
            
        }
        else
        {
            throw new Exception("El Objeto a eliminar no se encuentra en el sistema");
        }
    }
    //al invocar este metodo nos devuelve un Objeto de la clase Inventario que 
    //se encuentra guardado en la lista con el iten que pasamos como argumento a este metodo,
    //en caso que el iten que pasamos como argumento no se encuentre este debe lanzar error 
    public Inventario buscarObjeto(String item) throws Exception
    {
        Inventario miObjeto=null;
        Archivos.recuperarObjeto();
        if(listaDeObjetos.containsKey(item)==true)
        {
            miObjeto= listaDeObjetos.get(item);
        }
        else
        {
            throw new Exception("El Objeto a buscar no se encuentra en el sistema");
        }
        return miObjeto;
    }   
     
}
