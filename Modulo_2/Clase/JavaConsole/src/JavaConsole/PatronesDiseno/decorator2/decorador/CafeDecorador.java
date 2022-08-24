package JavaConsole.PatronesDiseno.decorator2.decorador;

import JavaConsole.PatronesDiseno.decorator2.Configurable;

abstract public class CafeDecorador implements Configurable {
    protected Configurable cafe;

    public CafeDecorador(Configurable cafe) {
        this.cafe = cafe;
    }
}
