package JavaConsole.Arreglos;

import java.util.Scanner;

public class EjemploArreglosBuscarNumero {
    public static void main(String[] args) {
/* //Ejemplo 1, descomentar para probar
        int[] a = new int[10];

        Scanner s = new Scanner(System.in);

        for(int i = 0; i < a.length; i++){
            System.out.print("Ingrese un número: ");
            a[i] = s.nextInt();
        }

        System.out.println("\r\nIngrese un número a buscar:");
        int num = s.nextInt();
        int i = 0;
        //for(; i < a.length && a[i] != num; i++){}

        //Este for hace lo mismo que el for de arriba for(; i < a.length && a[i] != num; i++){}
        for (;i < a.length; i++){
            if (a[i] == num){
                break;
            }
        }

        if(i == a.length){
            System.out.println("Número no encontrado");
        } else if(a[i] == num){
            System.out.println("Encontrado en la posición: " + i);
        }

 */ //Ejemplo 2, descomentar para probar
        /*int[] arregloNumeros = new int[100];
        for(int i = 0; i < 100; i++){
            arregloNumeros[i] = i;
        }

        for (int i = 0; i < arregloNumeros.length; i+=2){
            if (i == 10){
                System.out.println("Terminé");
                System.out.println("Acá debería ir el 10");
                break;
            }
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
        }

        for (int i = 0; i < arregloNumeros.length; i+=2){
            if (i == 10){
                System.out.println("Terminé");
                System.out.println("Acá debería ir el 10");
                continue;
            }
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
            System.out.println(arregloNumeros[i]);
        }*/

        for(double x = 0; x < 100; x+=.001){
            System.out.println(x);
        }

        etiqueta:

        for(int i = 0; i < 10; i++){
            if (i == 2){
                continue etiqueta;
            }

            System.out.println(i);
        }

        System.out.println("Terminé");
    }
}
