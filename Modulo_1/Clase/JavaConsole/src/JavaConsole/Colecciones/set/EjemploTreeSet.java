package JavaConsole.Colecciones.set;

import JavaConsole.Colecciones.modelo.Alumno;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {

        Set<String> ts = new TreeSet<>((a, b) -> b.compareTo(a));

        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("tres");
        ts.add("cuatro");
        ts.add("cinco");

        System.out.println("ts = " + ts);
        
        Set<Integer> numeros = new TreeSet<>(Comparator.reverseOrder());
        numeros.add(1);
        numeros.add(5);
        numeros.add(4);
        numeros.add(2);
        numeros.add(3);
        numeros.add(10);
        System.out.println("numeros = " + numeros);

        Set<Double> doubles = new TreeSet<>(Comparator.reverseOrder());
        doubles.add(1.12312);
        doubles.add(5.56775);
        doubles.add(4.879779);
        doubles.add(2.0987986);
        doubles.add(3.43534);
        doubles.add(10.345132);
        System.out.println("doubles = " + doubles);
    }
}
