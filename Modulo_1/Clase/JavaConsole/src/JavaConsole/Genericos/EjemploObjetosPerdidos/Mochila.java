package JavaConsole.Genericos.EjemploObjetosPerdidos;

import java.util.Objects;

public class Mochila implements Comparable<Mochila> {
    private String marca;
    private String color;

    public Mochila(String marca, String color) {
        this.marca = marca;
        this.color = color;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public int compareTo(Mochila object) {
        return (this.color + this.marca).compareTo(object.color + object.marca);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Mochila mochila = (Mochila) o;
        return (this.marca + this.color).equals(mochila.marca + mochila.color);
    }

    @Override
    public int hashCode() {
        return (this.marca + this.color).hashCode();
    }
}