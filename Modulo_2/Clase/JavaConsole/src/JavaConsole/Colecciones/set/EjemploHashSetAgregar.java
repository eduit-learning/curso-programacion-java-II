package JavaConsole.Colecciones.set;

import JavaConsole.Colecciones.modelo.Alumno;

import java.util.*;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

        Set<String> hs = new HashSet<>();
        hs.add("uno");
        hs.add("dos");
        hs.add("tres");
        hs.add("cuatro");
        hs.add("cuatru");
        hs.add("cinco");
        System.out.println(hs);

        Set<Integer> enteros = new HashSet<>();
        enteros.add(1);
        enteros.add(2);
        enteros.add(3);
        enteros.add(10);
        enteros.add(100);
        System.out.println(enteros);

        Set<Double> doubles = new HashSet<>();
        doubles.add(100.4534);
        doubles.add(.324234234);
        doubles.add(30.234234);
        doubles.add(10.234234);
        doubles.add(1000.23423423);
        System.out.println(doubles);

        Set<Alumno> alumnos = new HashSet<>();
        alumnos.add(new Alumno("Hugo",10));
        alumnos.add(new Alumno("Paco", 2));
        alumnos.add(new Alumno("Luis", 200));
        alumnos.add(new Alumno("Pedro Pérez Penas", 344));
        alumnos.add(new Alumno("Juan Camaney", 3456));
        System.out.println(alumnos);
    }
}
