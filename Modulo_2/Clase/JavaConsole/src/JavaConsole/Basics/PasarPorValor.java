package JavaConsole.Basics;

/*
Pila o Stack todas las variables se almacenan en la pila
x, y, Persona, Banco, Auto, etc
Las variables por valor almacenan el val directo; numerico, caracteres, booleanos, enumeradores
Las variables por referencia almacenan la localidad de memoria

 */

public class PasarPorValor {
    public static void main(String[] args) {

        int i = 10;

        System.out.println("iniciamos el método main con i = " + i);
        test(i);
        System.out.println("Finaliza el método main con el valor de i (se mantiene igual) = " + i);
    }

    public static void test(int i) {
        System.out.println("Iniciamos el método test con i = " + i);
        i = 35;
        System.out.println("Finaliza el método test con i = " + i);
    }
}
