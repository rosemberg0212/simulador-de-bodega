
package Clases;

import Ventanas.VentanaPrincipal;


public class MainPrincipal {

    
    public static void main(String[] args) throws Exception {
        VentanaPrincipal ven = new VentanaPrincipal();
        ven.setVisible(true);
        Archivos ne = new Archivos();
        Archivos.recuperarObjeto();
        Archivos.recuperarLista();
    }
    
}
