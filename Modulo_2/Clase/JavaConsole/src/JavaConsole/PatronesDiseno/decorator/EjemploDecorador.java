package JavaConsole.PatronesDiseno.decorator;

import JavaConsole.PatronesDiseno.decorator.decorador.MayusculaDecorador;
import JavaConsole.PatronesDiseno.decorator.decorador.RemplazarEspaciosDecorador;
import JavaConsole.PatronesDiseno.decorator.decorador.ReversaDecorador;
import JavaConsole.PatronesDiseno.decorator.decorador.SubrayadoDecorador;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal Andrés!");

        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        ReversaDecorador reversa = new ReversaDecorador(mayuscula);
        SubrayadoDecorador subrayar = new SubrayadoDecorador(reversa);
        RemplazarEspaciosDecorador remplazar = new RemplazarEspaciosDecorador(subrayar);

        System.out.println(remplazar.darFormato());
    }
}
