package JavaConsole.Basics;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EjemploJavaUtilDate {
    public static void main(String[] args) {
        /* Descomentar para probar código
        Date fecha = new Date();

        System.out.println("fecha = " + fecha);

        SimpleDateFormat df = new SimpleDateFormat("EEEE dd 'de' MMMM, yyyy");
        String fechaStr = df.format(fecha);

        long j = 0;
        for(int i = 0; i < 999999999; i++){
            for(int k = 0; k < 5; k++) {
                j += i;
            }
        }
        System.out.println("j = " + j);

        Date fecha2 = new Date();
        long tiempoFinal = fecha2.getTime() - fecha.getTime();
        System.out.println("Tiempo transcurrido en el for = " + tiempoFinal);
        System.out.println("fechaStr = " + fechaStr);
         */

        //https://www.digitalocean.com/community/tutorials/java-simpledateformat-java-date-format
        String pattern = "EEEEE dd 'de' MMMMM 'de' yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("es", "MX"));
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
}
