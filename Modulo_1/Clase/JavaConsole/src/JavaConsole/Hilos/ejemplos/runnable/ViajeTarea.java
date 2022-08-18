package JavaConsole.Hilos.ejemplos.runnable;

//Generalmente se usa para cuando quieres utilizar hilos y no puedes extender de Thread, porque ya extiendes de
//otra clase
public class ViajeTarea implements Runnable{
    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        for(int i=0; i < 10; i++){
            System.out.println(i + " - " + nombre);
            try {
                Thread.sleep( (long)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalmente me voy de viaje a: " + nombre);

    }
}
