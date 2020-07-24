
package Clases;

import static Clases.Validar.listaDeObjetos;
import static Clases.Validar.listaDeUsuarios;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Archivos {
    public static void guardarUsuarios() throws IOException
    {
        try {
            //ObjectOutputStream escritorObjetos = new ObjectOutputStream(new FileOutputStream("Lista-usuarios.dat"));
            ObjectOutputStream escritorObjetos;
            FileOutputStream escritorArchivo;
            escritorArchivo = new FileOutputStream("lista-usuarios.dat");
            escritorObjetos = new ObjectOutputStream(escritorArchivo);
            escritorObjetos.writeObject(Validar.listaDeUsuarios);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void recuperarLista() throws Exception
    {
         ObjectInputStream lectorObjetos = new ObjectInputStream(new FileInputStream("lista-usuarios.dat"));
         listaDeUsuarios = (HashMap<String, Datos>) lectorObjetos.readObject();
         //return (HashMap<String, Datos>)lectorObjetos.readObject();
    }
    
    public static void guardarObjetos() throws IOException
    {
        try {
            ObjectOutputStream escritorLista;
            FileOutputStream escritorArchivo;
            escritorArchivo = new FileOutputStream("lista-Objetos.dat");
            escritorLista = new ObjectOutputStream(escritorArchivo);
            escritorLista.writeObject(Validar.listaDeObjetos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Validar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void recuperarObjeto() throws Exception
    {
        ObjectInputStream lectorObjetos = new ObjectInputStream(new FileInputStream("lista-Objetos.dat"));
         listaDeObjetos = (HashMap<String, Inventario>) lectorObjetos.readObject();
    }
}
