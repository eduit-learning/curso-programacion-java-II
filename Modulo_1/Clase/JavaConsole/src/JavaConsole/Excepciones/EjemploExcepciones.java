package JavaConsole.Excepciones;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora cal = new Calculadora();
        String numerador = JOptionPane.showInputDialog("ingrese un entero numerador:");
        String denominador = JOptionPane.showInputDialog("ingrese un entero denominador:");

        try {
            double division2 = cal.dividir(numerador, denominador);
            System.out.println("division2 = " + division2);
        } catch(FormatoNumeroException e){
            System.out.println("Se detecto una excepción: ingrese un número válido: " + e.getMessage());
            e.printStackTrace(System.out);
        }
        catch(DivisionPorZeroException ae){
            System.out.println("Capturamos la excepcion en tiempo de ejecución: " + ae.getMessage());
            main(args);
        } finally {
            System.out.println("Es opcional, pero se ejecuta siempre con excepción o sin!");
        }
        System.out.println("Continuamos con el flujo de nuestra aplicación!");
    }
}
