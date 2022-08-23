package JavaConsole.Genericos.EjemploObjetosPerdidos;

public class Cartera implements Comparable<Cartera> {
    private String material;
    private String color;

    public Cartera(String material, String color) {
        this.material = material;
        this.color = color;
    }

    public String getMaterial() {
        return this.material;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public int compareTo(Cartera o) {
        return (this.color + this.material).compareTo(o.color + o.material);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cartera cartera = (Cartera) o;
        return (this.material + this.color).equals(cartera.material + cartera.color);
    }

    @Override
    public int hashCode() {
        return (this.material + this.color).hashCode();
    }
}
