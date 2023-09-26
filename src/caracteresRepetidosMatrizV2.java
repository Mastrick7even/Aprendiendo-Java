import java.util.Scanner;

public class caracteresRepetidosMatrizV2 {
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);
        String palabraIngresada;
        int longitud;
        char[][] matriz = new char[5][5];
        // Pedir palabra por teclado y validar tamano correcto.
        System.out.println("Ingrese una palabra (tamano < 25): ");
        do {
            palabraIngresada = scanf.nextLine();
            longitud = palabraIngresada.length();
            if(longitud > 25){
                System.out.println("La palabra ingresada es muy larga, ingrese nuevamente.");
            }
        }while(longitud > 25);

        // Quitar las letras repetidas de la palabra ingresada.
        String palabraSinRepetir = eliminarRepetidos(palabraIngresada);

        // Transformar la palabra a mayuscula (solo para que se vea mejor en la matriz).
        String palabraMayus = palabraSinRepetir.toUpperCase();

        // Ingresar la palabra sin letras repetidas dentro de la matriz y luego imprimirla.
        llenarEimprimirMatriz(palabraMayus, matriz);
    }

    // FUNCIONES
    public static String eliminarRepetidos(String palabra){
        String palabraSinRepetidos = ""; // Crear String vacio que se ira llenando caracter a caracter (sin repetidos).
        for(int i = 0; i < palabra.length(); i++){
            char letraActual = palabra.charAt(i); // En cada iteracion se guarda un nuevo caracter de la palabra a medida que avanza.

            // Si "letraActual" no se encuentra en nuestro String "palabraSinRepetidos", entonces la agregamos, si ya existe, entonces no se agrega nada.
            if(palabraSinRepetidos.indexOf(letraActual) == -1){
                palabraSinRepetidos += letraActual;
            }
        }
        return palabraSinRepetidos;
    }
    public static void llenarEimprimirMatriz(String palabraSinRepetidos, char[][] matriz){
        int k = 0;
        //Llenar matriz
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(k < palabraSinRepetidos.length()){
                    matriz[i][j] = palabraSinRepetidos.charAt(k);
                    k++;
                } else {
                    matriz[i][j] = 'X';
                }
            }
        }
        //ImprimirMatriz
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println(" ");
        }
    }
}
