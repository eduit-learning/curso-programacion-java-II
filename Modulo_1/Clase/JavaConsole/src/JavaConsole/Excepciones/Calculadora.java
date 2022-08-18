package JavaConsole.Excepciones;

public class Calculadora {

    public double dividir(int numerador, int divisor) throws DivisionPorZeroException{
        if(divisor == 0){
            throw new DivisionPorZeroException("no se puede dividir por cero!");
        }
        return numerador/(double)divisor;
        /*
            short -> 16 bits
            int -> 32 bits
            long -> 64 bits
            float -> 64 bits
            double -> 128 bits

            short + short = short;
            short + int = int -> [asumiento que 100 es elímite superios de short] 100 + 100 = (int) 200;

            int /double = double;

            [asumiento que 100 es elímite superior de short y asumiento que el rango short es -100 - 100]
            (short) 100 + (short) 100 = 0
         */
    }

    public double dividir(String numerador, String divisor)
            throws DivisionPorZeroException, FormatoNumeroException {
        try {
            int num = Integer.parseInt(numerador);
            int div = Integer.parseInt(divisor);
            return this.dividir(num, div);
        } catch (NumberFormatException e){
            throw new FormatoNumeroException("debe ingresar un número en el numerador y divisor");
        }
    }
}
