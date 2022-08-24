package JavaConsole.Genericos.EjemploObjetosPerdidos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObjetoPerdido<T> implements Iterable<T> {
    private List<T> objetos;

    public ObjetoPerdido() {
        this.objetos = new ArrayList<>();
    }

    public void add(T objeto) {
        this.objetos.add(objeto);
    }

    public boolean contains(T objeto) {
        return this.objetos.contains(objeto);

        //Esta es una forma de implementación, Funcional pero no práctica
        /*for (T obj : this.objetos) {
            if (obj instanceof Mochila) {
                Mochila tmp = (Mochila) obj;
                Mochila tmpBuscar = (Mochila) objeto;
                if (tmp.compareTo(tmpBuscar) == 0) {
                    return true;
                }
            }

            if (obj instanceof Celular) {
                Celular tmp = (Celular) obj;
                Celular tmpBuscar = (Celular) objeto;
                if (tmp.compareTo(tmpBuscar) == 0) {
                    return true;
                }
            }

            if (obj instanceof Cartera) {
                Cartera tmp = (Cartera) obj;
                Cartera tmpBuscar = (Cartera) objeto;
                if (tmp.compareTo(tmpBuscar) == 0) {
                    return true;
                }
            }
        }

        return false;*/
    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}