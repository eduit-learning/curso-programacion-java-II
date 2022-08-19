package JavaConsole.Hilos.ejemplos.threads;

import JavaConsole.Excepciones.DivisionPorZeroException;

import java.util.function.DoubleToIntFunction;

public class NombreThread extends Thread {
    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            System.out.println("se inicia el método run del hilo " + getName());

            for (int i = 0; i < 100; i++) {
                Thread.sleep(500);

                //No se recomienda y no es una buena práctica color try anidados
                //try {
                System.out.println(this.getName() + " - Iteración: " + i);
                //} catch (Exception ex) {
                //ex.printStackTrace();
                //}

            }
            System.out.println("finaliza el hilo... " + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NullPointerException ex) {

        } catch (Exception ex) {

        } finally {
            //El código dentro de este bloque siempre se ejecuta, no impora si ocurrió una excepción o no
        }

        /* Otra forma de implementar el método run
        System.out.println("se inicia el método run del hilo " + getName());

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                System.out.println(this.getName());
            } catch (Exception ex){
                e.printStackTrace();
            }
        }
        System.out.println("finaliza el hilo");

         */
    }
}
