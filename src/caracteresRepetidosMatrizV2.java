import java.util.Scanner;

public class caracteresRepetidosMatrizV2 {
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        String palabraIngresada;
        char[][] matriz = new char[5][5];
        // Pedir palabra por teclado y validar tamano correcto.
        System.out.print("Ingrese una frase: ");
        palabraIngresada = scanf.nextLine();
        palabraIngresada = palabraIngresada.toUpperCase();

        // Quitar las letras repetidas de la palabra ingresada.
        String palabraSinRepetir = eliminarRepetidos(palabraIngresada);

        // Ingresar la palabra sin letras repetidas dentro de la matriz y luego imprimirla.
        llenarEimprimirMatriz(palabraSinRepetir, matriz);

        System.out.print("Ingresa una palabra para codificarla: ");
        String palabraAcodificar = scanf.nextLine();
        String palabraEncriptada = codificarPalabra(matriz, palabraAcodificar);
        System.out.println("La palabra encriptada es: " + palabraEncriptada);
        String palabraDesencriptada = decodificarPalabra(matriz, palabraEncriptada);
        System.out.println("La palabra desencriptada es: " + palabraDesencriptada);
    }

    // FUNCIONES
    public static String decodificarPalabra(char[][] matriz, String palabra) {
        String palabraDecodificada = "";
        palabra = palabra.toUpperCase();
        for (int k = 0; k < palabra.length(); k++) {
            boolean accion = false;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (matriz[i][j] == 32 || matriz[0][0] == palabra.charAt(k)) {
                        palabraDecodificada += palabra.charAt(k);
                        accion = true;
                        break; //para asi salir del ciclo j, en caso de ya haber encontrado la letra en la fila correspondiente.
                    } else if (matriz[i][j] == palabra.charAt(k) ) {
                        if (j == 0 && i > 0) {
                            palabraDecodificada += matriz[i - 1][4];
                        } else if(j < 4 && matriz[i][j+1] == 32){
                            palabraDecodificada += matriz[i][j-1];

                        } else {
                            palabraDecodificada += matriz[i][j-1];
                        }
                        accion = true;
                        break;
                    } else if (j < 4 && matriz[i][j+1] == 32) {
                        if(palabra.charAt(k) == '1'){
                            palabraDecodificada += matriz[i][j];
                        }
                        accion = true;
                        break;
                    }
                }
                if (accion) {
                    break;
                }
            }
        }
        return palabraDecodificada;
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
                            if (matriz[i+1][0] == 32) {
                                palabraCodificada += letra;
                            } else {
                                palabraCodificada += matriz[i + 1][0];
                            }
                        } else if (matriz[i][j + 1] == 32) {
                            palabraCodificada += '1';
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
