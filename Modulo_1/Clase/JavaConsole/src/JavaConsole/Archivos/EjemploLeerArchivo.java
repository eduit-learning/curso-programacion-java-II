package JavaConsole.Archivos;

import JavaConsole.Archivos.servicio.ArchivoServicio;

import java.io.File;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\tmp\\java.txt";
        ArchivoServicio servicio = new ArchivoServicio();

        System.out.println(System.getProperty("user.dir") + File.separator + "src\\JavaConsole\\Basics\\config.properties");

        System.out.println(servicio.leerArchivo(nombreArchivo));
    }
}
