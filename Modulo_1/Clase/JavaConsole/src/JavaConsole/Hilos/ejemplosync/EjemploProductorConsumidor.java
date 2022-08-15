package JavaConsole.Hilos.ejemplosync;

import JavaConsole.Hilos.ejemplosync.runnable.Consumidor;
import JavaConsole.Hilos.ejemplosync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
