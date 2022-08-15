package JavaConsole.PatronesDiseno.decorator.decorador;

import JavaConsole.PatronesDiseno.decorator.Formateable;

abstract public class TextoDecorador implements Formateable {
    protected Formateable texto;

    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}
