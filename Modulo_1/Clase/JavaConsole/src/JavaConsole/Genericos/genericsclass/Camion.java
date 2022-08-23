package JavaConsole.Genericos.genericsclass;

/*
    Deben de crear un departamento de objetos perdidos, este departamento puede tener colecciones
    de objetos distintos. Por ejemplo Mochilas, Chamarras, Carteras, etc. Deben crear la estructura de
    clases para este depatamtent y un método para buscar elementos perdidos.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T> {

    private List<T> objetos;
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
    }

    public void add(T objeto){
        if(this.objetos.size() <= max) {
            this.objetos.add(objeto);
        } else {
            throw new RuntimeException("no hay más espacio.");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
