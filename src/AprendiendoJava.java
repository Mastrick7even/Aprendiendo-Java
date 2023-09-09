import java.util.Scanner;

public class AprendiendoJava {
    //Metodo principal
    public static void main(String args[]){
        System.out.println("Hola mundo desde Java");

        //Variables de tipo primitivos: Enteros y flotante
        int variableEntera = 26;
        System.out.println(variableEntera);

        //Variable tipo String
        String variableCadena = "Mi nombre es Bastian";
        System.out.println(variableCadena);

        //Inferencia de tipos de datos: var
        var variableEntera2 = "45";
        var variableCadena2 = "Como estas?";
        System.out.println(variableEntera2);
        System.out.println("Hola amigo, " + variableCadena2);

        //Scanner para leer entradas por teclado
        Scanner scanf = new Scanner(System.in);
        //ejemplo: pedir el nombre
        System.out.println("Ingrese su nombre: ");
        var nombre = scanf.nextLine();
        System.out.println("Su nombre es " + nombre);

        //Tipos de datos primitivos
        //tipos primitivos enteros: byte, short, int, long
        byte numeroByte = (byte) 129;
        System.out.println("Valor byte:" + numeroByte);
        System.out.println("Valor minimo byte:" + Byte.MIN_VALUE);
        System.out.println("Valor maximo byte:" + Byte.MAX_VALUE);

        short numeroShort = (short)32768;
        System.out.println("numeroShort = " + numeroShort);
        System.out.println("Valor minimo short:" + Short.MIN_VALUE);
        System.out.println("Valor maximo short:" + Short.MAX_VALUE);

        int numeroInt = (int)2147483648L;
        System.out.println("numeroInt = " + numeroInt);
        System.out.println("Valor minimo int:" + Integer.MIN_VALUE);
        System.out.println("Valor maximo int:" + Integer.MAX_VALUE);

        long numeroLong = 9223372036854775807L;
        System.out.println("numeroLong = " + numeroLong);
        System.out.println("Valor minimo long:" + Long.MIN_VALUE);
        System.out.println("Valor maximo long:" + Long.MAX_VALUE);

        //tipos primitivos de tipo flotante: float y double
        float numeroFloat = (float)3.4028235E38D;
        System.out.println("numeroFloat = " + numeroFloat);
        System.out.println("Valor minimo tipo float: " + Float.MIN_VALUE);
        System.out.println("Valor maximo tipo float: " + Float.MAX_VALUE);

        double numeroDouble = 1.7976931348623157E308;
        System.out.println("numeroDouble = " + numeroDouble);
        System.out.println("Valor minimo tipo double: " + Double.MIN_VALUE);
        System.out.println("Valor maximo tipo double: " + Double.MAX_VALUE);
    }
}
