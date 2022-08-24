package JavaConsole.PatronesDiseno.factory;

import JavaConsole.PatronesDiseno.factory.producto.PizzaNewYorkItaliana;
import JavaConsole.PatronesDiseno.factory.producto.PizzaNewYorkPepperoni;
import JavaConsole.PatronesDiseno.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory {
    @Override
    PizzaProducto crearPizza(String tipo) {
        return switch (tipo) {
            case "vegetariana" -> new PizzaNewYorkVegetariana();
            case "pepperoni" -> new PizzaNewYorkPepperoni();
            case "italiana" -> new PizzaNewYorkItaliana();
            default -> null;
        };
    }
}
