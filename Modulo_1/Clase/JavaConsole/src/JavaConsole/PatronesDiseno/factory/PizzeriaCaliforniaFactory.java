package JavaConsole.PatronesDiseno.factory;

import JavaConsole.PatronesDiseno.factory.producto.PizzaCaliforniaPepperoni;
import JavaConsole.PatronesDiseno.factory.producto.PizzaCaliforniaQueso;
import JavaConsole.PatronesDiseno.factory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;
        switch (tipo){
            case "queso":
                producto = new PizzaCaliforniaQueso();
                break;
            case "pepperoni":
                producto = new PizzaCaliforniaPepperoni();
                break;
            case "vegetariana":
                producto = new PizzaCaliforniaVegetariana();
                break;
        }
        return producto;
    }
}
