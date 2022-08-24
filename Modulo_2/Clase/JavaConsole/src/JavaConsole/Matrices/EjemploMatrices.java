package JavaConsole.Matrices;

/*
* Ejericicio 1: Arreglos dinámicos, se requiere que en un arreglo se puedn meter tantos elementos como sea necesario.
* Pued ser 1 o n, el arreglo debe permitirlo
*
* Ejercicio 2: Recorrer e imprimir el conteido del arreglo de Objetos,
* línea 13 (Object[] columnasDinamicas = new Object[3];)
* */

import javax.swing.text.Document;
import java.util.Arrays;

public class EjemploMatrices {
    public static void main(String[] args) {
/* Ejercicio 1: Descomentar para probar
        Object[] columnasDinamicas = new Object[3];
        columnasDinamicas[0] = new int[2];
        columnasDinamicas[1] = new double[3];
        columnasDinamicas[2] = new String[1];

        for(int i = 0; i < columnasDinamicas.length; i++){
            for(int j = 0; j < ((int[])columnasDinamicas[i]).length; j++){
                int[] tmp = (int[])columnasDinamicas[i];
                tmp[j] = j;
                ((int[])columnasDinamicas[i])[j] = j;
            }
        }

        for(int i = 0; i < columnasDinamicas.length; i++){
            if (columnasDinamicas[i] instanceof int[]){

                for(int elemento : (int[]) columnasDinamicas[i]){

                }

            } else if (columnasDinamicas[i] instanceof double[]) {
                for(double elemento : (double[]) columnasDinamicas[i]){

                }
            }
            else{
                for(String elemento : (String[]) columnasDinamicas[i]){

                }
            }
        }

        int[][] numeros = new int[2][4];

        numeros[0][0] = 1;
        numeros[0][1] = 2;
        numeros[0][2] = 3;
        numeros[0][3] = 4;

        numeros[1][0] = 11;
        numeros[1][1] = 12;
        numeros[1][2] = 13;
        numeros[1][3] = 14;

        System.out.println("número de filas: " + numeros.length);
        System.out.println("número de columnas: " + numeros[0].length);

        System.out.println("primer elemento de la matriz: " + numeros[0][0]);
        System.out.println("último elemento: " + numeros[numeros.length -1][numeros[1].length -1]);

        int num1 = numeros[0][0];
        int num2 = numeros[0][1];
        int num3 = numeros[0][2];
        int num4 = numeros[0][3];
        int num5 = numeros[1][0];
        int num6 = numeros[1][1];
        int num7 = numeros[1][2];
        int num8 = numeros[1][3];

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);
        System.out.println("num5 = " + num5);
        System.out.println("num6 = " + num6);
        System.out.println("num7 = " + num7);
        System.out.println("num8 = " + num8);

        for (int i = 0; i < numeros.length; i++){
            System.out.println("Esta es la fila" + (i+1));
            for(int j = 0; j < numeros[i].length; j++){
                System.out.println("Columna " + numeros[i][j]);
            }
        }

        int[] numerosDinamico = new int[1];

        numerosDinamico[0] = 1;

        for(int i = 2; i < 1000; i++) {
            numerosDinamico[i] = 1;
        }
 */
        intArray = new int[1];
        intArray[0] = 1;

        for(int element : intArray){
            System.out.println(element);
        }

        for (int z = 2; z <= 10000; z++){
            AddNewElement2(z);
        }

        for(int element : intArray){
            System.out.println(element);
        }
    }

    private static int[] intArray;
    private static void AddNewElement(int newElement) {
        int[] temp = intArray;
        intArray = new int[temp.length + 1];

        for(int i=0; i < temp.length; i++){
            intArray[i] = temp[i];
        }

        intArray[temp.length] = newElement;
    }

    private static void AddNewElement2(int newElement){
        intArray = Arrays.copyOf(intArray,intArray.length + 1);
        intArray[intArray.length-1] = newElement;
    }
}
