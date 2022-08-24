package JavaConsole.PatronesDiseno.observer.ejemplos;

import JavaConsole.PatronesDiseno.observer.Corporacion;

public class EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver( (observable, obj) -> {
            System.out.println("John: " + observable );
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Andrés: " + observable );
        });

        google.addObserver((observable, obj) -> {
            System.out.println("Maria: " + observable );
        });
        google.modificaPrecio(2000);
    }
}
