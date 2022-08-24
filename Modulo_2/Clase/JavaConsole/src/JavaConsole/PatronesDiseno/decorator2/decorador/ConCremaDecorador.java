package JavaConsole.PatronesDiseno.decorator2.decorador;

import JavaConsole.PatronesDiseno.decorator2.Configurable;

public class ConCremaDecorador extends CafeDecorador {
    public ConCremaDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() + 2.5f;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes() + ", Crema";
    }
}
