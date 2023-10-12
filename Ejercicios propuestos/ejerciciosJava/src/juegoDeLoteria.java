import java.util.Random;
import java.util.Scanner;

public class juegoDeLoteria {
    public static void main(String[] args){
        System.out.println("Bienvenido a la loteria!");
        System.out.println("Escoja los numeros de su carton, son 7 en total y deben estar en orden.");
        System.out.println("Ingrese uno a uno, los primeros 6 numeros de su carton:");
        int[] numerosIngresados = new int[7];

        // Ingreso de numeros por teclado
        for(int i = 0; i < 7; i++){
            if(i == 6){
                System.out.print("Ingrese comodin: ");
                numerosIngresados[i] = validarNumeroIngresado(numerosIngresados);
                break;
            }
            System.out.print("Numero " + (i+1) + ": ");
            numerosIngresados[i] = validarNumeroIngresado(numerosIngresados);
        }

        //Imprimir numeros elegidos
        System.out.println("Numeros elegidos: ");
        for (int numero : numerosIngresados) {
            System.out.print(numero + " ");
        }
        System.out.println(" "); // salto de linea

        //Ordenar numeros elegidos de menor a mayor
        ordenamientoDeInsercion(numerosIngresados);

        //Imprimir
        System.out.println("Numeros elegidos ordenados: ");
        for (int numero : numerosIngresados) {
            System.out.print(numero + " ");
        }
        System.out.println(" "); // salto de linea

        // Generar numeros sacados de la tombola aleatoriamente
        int[] tombola = generarTombola();

        //Ordenar numeros elegidos de menor a mayor
        ordenamientoDeInsercion(tombola);

        //Imprimir tombola
        System.out.println("Numeros de la tombola: ");
        for (int numero : tombola) {
            System.out.print(numero + " ");
        }


    }

    public static void comprobarLoteria(int[] numerosElegidos, int[] tombola){
        Scanner scanf = new Scanner(System.in);
        int[] errados = new int[6];
        int j = 0, num;
        if(numerosElegidos[6] == tombola[6]){ // comprobar que el participante acerto el comodin
            for(int i = 0; i < 6; i++){
                if(numerosElegidos[i] != tombola[i]){
                    errados[j] = numerosElegidos[i];
                    j++;
                }
            }
        } else { // si el participante no acerto el comodin
            System.out.println("Te equivocaste al elegir el comodin, te dare otra oportunidad.");
            if(numerosElegidos[6] < tombola[6]){
                System.out.println("PISTA: El comodin es un numero mayor al que elegiste.");
                System.out.print("Ingresa nuevo comodin: ");
            }else{
                System.out.println("PISTA: El comodin es un numero menor al que elegiste.");
                System.out.print("Ingresa nuevo comodin: ");
            }
            num = scanf.nextInt();
            if(num == tombola[6]){
                System.out.println("Felicidades, acertaste el comodin!!");
            }
        }

    }

    // Ordenamiento de arreglos menor a mayor por metodo de insercion
    public static void ordenamientoDeInsercion(int[] arreglo){
        for(int i = 1; i < 6; i++){
           int numeroActual = arreglo[i];
           int j = i-1;
           while(j >= 0 && arreglo[j] > numeroActual){
                arreglo[j+1] = arreglo[j];
                j--;
           }
           arreglo[j+1] = numeroActual;
        }
    }

    public static int validarNumeroIngresado(int[] numerosIngresados){
        Scanner scanf = new Scanner(System.in);
        int num = scanf.nextInt();
        // Validar rango numerico entre 1 y 20
        do{
           if(num < 1 || num > 20){
                System.out.println("Error, numero ingresado esta fuera de rango (1 <= num <= 20).");
                System.out.print("Ingresa nuevamente: ");
                num = scanf.nextInt();
           }
        }while(num < 1 || num > 20);

        // Validar que numero ingresado no este repetido
            for(int i = 0; i < numerosIngresados.length; i++){
                if(numerosIngresados[i] == num){
                    System.out.print("Ese numero ya lo escogiste antes. Ingresa nuevamente: ");
                    num = scanf.nextInt();
                    i = -1; //Reiniciar bucle de verificacion
                }
            }
        return num;
    }
    public static int[] generarTombola(){
        Random random = new Random();
        int[] tombola = new int[7];
        for(int i = 0; i < 7; i++){
            //Generar un numero aleatorio en el rango de 0 a 19;
            int numRandom = random.nextInt(20) + 1;
            tombola[i] = numRandom;
        }
        return tombola;
    }
}
