package JavaConsole.PatronesDiseno.factory.ejemplo;

import JavaConsole.PatronesDiseno.factory.PizzaProducto;
import JavaConsole.PatronesDiseno.factory.PizzeriaCaliforniaFactory;
import JavaConsole.PatronesDiseno.factory.PizzeriaNewYorkFactory;
import JavaConsole.PatronesDiseno.factory.PizzeriaZonaAbstractFactory;

public class EjemploFactory {
    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();
        
        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza " + pizza.getNombre());
        
        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Andrés ordena una " + pizza.getNombre());
        
        pizza = california.ordenarPizza("vegetariana");
        System.out.println("James ordena " + pizza.getNombre());
        
        pizza = ny.ordenarPizza("vegetariana");
        System.out.println("Linus ordena la pizza " + pizza.getNombre());
        
        pizza = california.ordenarPizza("pepperoni");
        System.out.println("John ordena la pizza " + pizza.getNombre());

        System.out.println("pizza = " + pizza);
    }
}
