import java.util.Scanner;

public class sumatoria {

    public static int factorial(int x){
        int fact = 1;
        if(x == 0 || x == 1){
            return 1;
        } else{
            for(int i = 1; i <=x; i++){
                fact = fact * i;
            }
            return fact;
        }
    }
    public static void main(String args[])throws Exception{
        System.out.println("Ingrese un numero par: ");
        Scanner scanf = new Scanner(System.in);
        int numero;
        //validacion para que el numero ingresado sea par
        do {
            numero = scanf.nextInt();
            if(numero%2 != 0){
                System.out.println("Error, el numero no es par. Ingrese nuevamente.");
            }
        }while(numero % 2 != 0);

        int suma = 0;
        for(int i = 1; i <= numero; i++){
            //validacion contador par o impar
            if(i % 2 == 0){
                //suma = suma + Math.pow(i+ (i - 1), i);
                suma += factorial(i*(i-1));
            } else{
                suma += Math.pow(i + (i - 1) , i);
            }
        }
        System.out.println("El resultado de la sumatoria es "+suma);
    }
}
