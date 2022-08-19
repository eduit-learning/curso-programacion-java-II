package JavaConsole.Hilos.ejemplos;

import JavaConsole.Hilos.ejemplos.runnable.ViajeTarea;
import JavaConsole.Hilos.ejemplos.threads.NombreThread;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Isla de Pascua")).start();
        //El código comentado de la siguiente linea es lo mismo que la línea anterior
        /*Thread x = new Thread(new ViajeTarea(("Isla de Pascua")));
        x.start();
         */

        new Thread(new ViajeTarea("Robinson Crusoe")).start();
        new Thread(new ViajeTarea("Juan Fernandez")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();
    }
}
