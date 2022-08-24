package JavaConsole.Colecciones.list;

import JavaConsole.Colecciones.modelo.Alumno;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.comparing;

public class EjemploArrayList {
    public static void main(String[] args) {

        ArrayList<Alumno> al = new ArrayList<>();

        System.out.println(al + ", size = " + al.size());
        System.out.println("está vacía = " + al.isEmpty());
        //List: [][]
        al.add(new Alumno("Pato", 5));
        //List: [5][]
        al.add(new Alumno("Cata", 6));
        //List: [5][6]
        al.add(new Alumno("Luci", 4));
        //List: [5][6][4]
        al.add(2, new Alumno("Jano", 7)); //Este solo arrima los indices
        //List: [5][6][7][4]
        al.set(3, new Alumno("Andres", 3)); //Set sobreescribe
        //List: [5][6][7][3]

        System.out.println(al + ", size = " + al.size());

        al.remove(new Alumno("Jano", 7));
        //al.remove(0);
        System.out.println(al + ", size = " + al.size());

        boolean b = al.contains(new Alumno("Cata", 6));
        System.out.println("La lista contiene a Cata = " + b);

        Object a[] = al.toArray();
        for(int i=0; i<a.length;i++){
            System.out.println("Desde el arreglo = " + a[i]);
        }
    }
}

/*
    Persona
        Nombre
        Sexo
        Fecha de nacimiento

    Estudiante que hereda de Persona
        Por herencia
            Nombre
            Sexo
            Fecha de nacimiento

        Carecterísticas propias
            Matricula
            Nombre de la escuela
            Horario
            Grado

      Estudiante x = new Persona() //Esto no es válido porque persona no hereda de estudiantes
      Persona y = new Estudiante() //Esto si es válido porque estudiante implementa/hereda de persona
      y.Nombre
      y.Sexo
      y.Fecha de Nacimiento

      No es válido
      y.Matricula
      y.Nombre de la escuela

      Esto a menos que haga un casting
      ((Estudiante) y).Matricula
      ((Estudiante) y).Nombre de la escuela
 */