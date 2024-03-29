package JavaConsole.Arreglos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/*
productos 0xABC123 (0XABC124, 0XABC125, 0XABC126)
[0]    0XABC124 -> null
[1]    0XABC125 -> null
[2]    0XABC126 -> null
*/


public class EjemploArreglos {

    public static void main(String[] args) {

        String[] productos;
        //Operación de base datos o un algo que me regrese la cantidad a ocupar
        productos = new String[7];
        productos[0] = "Kingston Pendrive 64GB";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "Macbook Air";
        productos[5] = "Chromecast 4ta generación";
        productos[6] = "Bicicleta Oxford";
        //productos[7] = "asdadssd";

        ArrayList<Integer> x =new ArrayList<Integer>();
        //utilizo mi array y llega al 10 mil
        //lo limpio para utilizarlo de nuevo

        Arrays.sort(productos);

        String prod1 = productos[0];
        String prod2 = productos[1];
        String prod3 = productos[2];
        String prod4 = productos[3];
        String prod5 = productos[4];
        String prod6 = productos[5];
        String prod7 = productos[6];

        System.out.println("productos[0] = " + prod1);
        System.out.println("productos[1] = " + prod2);
        System.out.println("productos[2] = " + prod3);
        System.out.println("productos[3] = " + prod4);
        System.out.println("productos[4] = " + prod5);
        System.out.println("productos[5] = " + prod6);
        System.out.println("productos[6] = " + prod7);

        int[] numeros = new int[4];

        numeros[0] = 10;
        numeros[1] = Integer.valueOf("7");
        numeros[2] = 35;
        numeros[3] = -1;
        // numeros[4] = 5;

        Arrays.sort(numeros);

        int i = numeros[0];
        int j = numeros[1];
        int k = numeros[2];
        int l = numeros[numeros.length - 1];
        //int m = numeros[4];

        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        System.out.println("l = " + l);

        for (int n = 0; n < numeros.length; n++){
            System.out.println(numeros[n]);
        }

        for(int element : numeros){
            System.out.println(element);
        }
    }
}