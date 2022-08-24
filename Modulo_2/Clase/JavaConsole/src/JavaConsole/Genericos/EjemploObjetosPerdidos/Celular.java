package JavaConsole.Genericos.EjemploObjetosPerdidos;

public class Celular implements Comparable<Celular> {
    private String modelo;
    private String color;

    public Celular(String modelo, String color) {
        this.modelo = modelo;
        this.color = color;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public int compareTo(Celular o) {
        return (this.color + this.modelo).compareTo(o.color + o.modelo);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Celular celular = (Celular) o;
        return (this.modelo + this.color).equals(celular.modelo + celular.color);
    }

    @Override
    public int hashCode() {
        return (this.modelo + this.color).hashCode();
    }
}
