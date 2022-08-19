package JavaConsole.Hilos.ejemplos.threads;

public class CaballoCarrera extends Thread {
    private int millas = 500;

    private double millasRecorridas = 0;

    public CaballoCarrera(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        try {
            System.out.println(getName() + " arranca!!!! - " + this.millasRecorridas + " millas recorridas");

            while (millasRecorridas < millas) {
                millasRecorridas += Math.random();
                System.out.println(getName() + " avanzó - " + this.millasRecorridas + " millas");
                Thread.sleep(100);
            }

            System.out.println(getName() + " finalizó la carrera!!! - " + this.millasRecorridas + " millas recorridas");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}