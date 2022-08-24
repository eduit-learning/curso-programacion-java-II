package JavaConsole.Genericos.EjemploObjetosPerdidos;

public class DepartamentoObjetosPerdidos {
    public static ObjetoPerdido<Mochila> mochilas;
    public static ObjetoPerdido<Celular> celulares;
    public static ObjetoPerdido<Cartera> carteras;

    public static void main(String[] args) {
        mochilas = new ObjetoPerdido<>();
        celulares = new ObjetoPerdido<>();
        carteras =  new ObjetoPerdido<>();

        Mochila chenson_Rojo = new Mochila("Chenson", "Rojo");
        mochilas.add(chenson_Rojo);
        mochilas.add(new Mochila("Samsonite", "Verde"));
        mochilas.add(new Mochila("Tacachis", "Azul"));

        celulares.add(new Celular("iPhone 10", "Gris"));
        celulares.add(new Celular("Samsung XL3", "Azul"));
        celulares.add(new Celular("Xiami Mi 12", "Rojo"));

        carteras.add(new Cartera("Piel", "Café"));
        carteras.add(new Cartera("Lona", "Verde"));
        carteras.add(new Cartera("Tela", "Morada"));

        boolean result = mochilas.contains(new Mochila("Chenson","Rojo"));
        System.out.println(result);

        result = mochilas.contains(chenson_Rojo);
        System.out.println(result);

        result = celulares.contains(new Celular("iPhone 10","Gris"));
        System.out.println(result);

        result = carteras.contains(new Cartera("Tela", "Morada"));
        System.out.println(result);
    }
}
