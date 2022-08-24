/*Simulación de  Carrera de caballos usando hilos
    Podemos tener varios caballos, la cantidad debe ser aleatoria
    Los caballos deben recorrer una cantidad de millas que deben ser definidas (100, 1000, 10000)
    Dependiendo de un número aleatorio son las millas que irpan recorriendo

    La aplicación debe ir mostrando las millas que van recorriendo los caballos y alfinal debe mostrar los lugares
 */


package JavaConsole.Hilos.ejemplos;

import JavaConsole.Hilos.ejemplos.threads.CaballoCarrera;
import JavaConsole.Hilos.ejemplos.threads.NombreThread;

import java.util.Random;
import java.util.Scanner;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        /*Thread hilo = new NombreThread("Jhon Doe");
        hilo.start();
        Thread.sleep(2000);
        Thread hilo2 = new NombreThread("Maria");
        hilo2.start();
        Thread.sleep(2000);
        NombreThread hilo3 = new NombreThread("Pepe");
        hilo3.start();
        hilo.interrupt();
        System.out.println(hilo.getState() + "*************************************************************************************************************");
        /*
        /*for(int i = 0; i < 999999999; i++){
            Thread j = new NombreThread("" + i);
            j.start();
        }
        */

        Random rnd = new Random();
        int caballos = rnd.nextInt(20, 30);

        System.out.println("La cantidad de cabbalos que competiran son: " + caballos);
        System.out.println("Presione 'enter' para inciar la carrera");
        new Scanner(System.in).nextLine();

        Thread caballo = new CaballoCarrera("Nomre");
        caballo.start();

        Thread caball2 = new CaballoCarrera("Nomr2");
        caball2.start();

        Thread caball3 = new CaballoCarrera("Nomr3");
        caball3.start();

        Thread caball4 = new CaballoCarrera("Nomr4");
        caball4.start();

        Thread caball5 = new CaballoCarrera("Nomr5");
        caball5.start();

        for (int i = 1; i <= caballos; i++) {
            Thread caballoFor = new CaballoCarrera("Caballo " + i);
            caballo.start();
        }

        Thread[] caballosArray = new CaballoCarrera[caballos];
        for (int i = 0; i < caballos; i++) {
            caballosArray[i] = new CaballoCarrera("Caballo " + (i + 1));
            caballosArray[i].start();
        }

        caballosArray[9].interrupt();

        System.out.println("Finalizó la carrera");
    }
}