package JavaConsole.Basics;

public class OperadoresAsignacion {
    public static void main(String[] args) {
        int i = 5;
        int j = i + 4;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        
        i += 2; // i = i + 2
        i =+ 2;
        System.out.println("i = " + i);

        i += 5; // i = i + 5
        System.out.println("i = " + i);
        
        j -= 4; // j = j - 4
        System.out.println("j = " + j);
        
        j *= 3; // j = j * 3;
        System.out.println("j = " + j);
        j /= 2; // i = i/2;

        for (int x =0; x<100; x++) {
            System.out.println(x);
        }
        for (int x =0; x<100; ++x) {
            System.out.println(x);
        }

        
        String sqlString = "select * from clientes as c";
        sqlString += " where c.nombre='Andres' ";
        sqlString += " and c.activo=1";
        System.out.println("sqlString = " + sqlString);
    }
}
