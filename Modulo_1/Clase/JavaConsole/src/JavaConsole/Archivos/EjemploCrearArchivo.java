package JavaConsole.Archivos;

import JavaConsole.Archivos.servicio.ArchivoServicio;

import java.nio.charset.Charset;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\tmp\\java.txt";

        //ArchivoServicio service = new ArchivoServicio();
        //service.crearArchivo2(nombreArchivo);

        System.out.println(Charset.defaultCharset());
    }
}
