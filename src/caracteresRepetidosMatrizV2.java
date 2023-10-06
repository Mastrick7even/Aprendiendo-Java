import java.util.Scanner;

public class caracteresRepetidosMatrizV2 {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        String palabraIngresada;
        int longitud;
        char[][] matriz = new char[5][5];
        // Pedir palabra por teclado y validar tamano correcto.
        System.out.print("Ingrese una frase: ");
        palabraIngresada = scanf.nextLine();
        longitud = palabraIngresada.length();

        // Quitar las letras repetidas de la palabra ingresada.
        String palabraSinRepetir = eliminarRepetidos(palabraIngresada);

        // Transformar la palabra a mayuscula (solo para que se vea mejor en la matriz).
        String palabraMayus = palabraSinRepetir.toUpperCase();

        // Ingresar la palabra sin letras repetidas dentro de la matriz y luego imprimirla.
        llenarEimprimirMatriz(palabraMayus, matriz);

        System.out.print("Ingresa una palabra para codificarla: ");
        String palabraAcodificar = scanf.nextLine();
        String palabraCodificada = codificarPalabra(matriz, palabraAcodificar);
        System.out.println("La palabra encriptada es: " + palabraCodificada);
    }

    public static String codificarPalabra(char[][] matriz, String palabra) {
        String palabraCodificada = "";
        palabra = palabra.toUpperCase();

        for (int k = 0; k < palabra.length(); k++) {
            char letra = palabra.charAt(k);
            boolean concatenar = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (matriz[i][j] == 32) {
                        palabraCodificada += letra;
                        concatenar = true;
                        break;
                    } else if (matriz[i][j] == letra) {
                        if (j == 4) {
                            palabraCodificada += matriz[i + 1][0];
                        } else if (matriz[i][j + 1] == 32) {
                            palabraCodificada += letra;
                        } else {
                            palabraCodificada += matriz[i][j + 1];
                        }
                        concatenar = true;
                        break;
                    }
                }
                if (concatenar) {
                    break;
                }
            }

        }
        return palabraCodificada;
    }


    /*public static String codificarPalabra(char[][] matriz, String palabra) {
        String palabraCodificada = "";
        palabra = palabra.toUpperCase();
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matriz[i][j] == 32) {
                    palabraCodificada += palabra.charAt(k);
                } else if (palabra.charAt(k) == matriz[i][j]) {
                    if (j == 4) { // Si llega al limite de la fila
                        palabraCodificada += matriz[i + 1][0]; // Bajar a la siguiente fila
                    } else {
                        palabraCodificada += matriz[i][j + 1];
                    }
                }
                k++;
                i = 5;
                j = 5;
            }
        }
        return palabraCodificada;
    }*/


    // FUNCIONES
    public static String eliminarRepetidos(String palabra) {
        String palabraSinRepetidos = ""; // Crear String vacio que se ira llenando caracter a caracter (sin repetidos).
        for (int i = 0; i < palabra.length(); i++) {
            char letraActual = palabra.charAt(i); // En cada iteracion se guarda un nuevo caracter de la palabra a medida que avanza.

            // Si "letraActual" no se encuentra en nuestro String "palabraSinRepetidos", entonces la agregamos, si ya existe, entonces no se agrega nada.
            if (palabraSinRepetidos.indexOf(letraActual) == -1 && letraActual != 32) {
                palabraSinRepetidos += letraActual;
            }
        }
        return palabraSinRepetidos;
    }

    public static void llenarEimprimirMatriz(String palabraSinRepetidos, char[][] matriz) {
        int k = 0;
        //Llenar matriz
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (k < palabraSinRepetidos.length()) {
                    matriz[i][j] = palabraSinRepetidos.charAt(k);
                    k++;
                } else {
                    matriz[i][j] = ' ';
                }
            }
        }
        //ImprimirMatriz
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println(" ");
        }
    }
}
