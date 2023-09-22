// Ingresar una cadena de tamano menor o igual a 25 e ingresarla dentro de una matriz cuadrada de tipo char
// de tamano 5, de tal manera que ningun caracter de la palabra se repita. EJ: Acupuntura = Acupntr
import java.util.Scanner;
import java.util.HashSet;
public class caracteresRepetidosMatriz {
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);
        char[][] matriz = new char[5][5];
        String palabra;
        int posicion = 0;
        System.out.println("Ingrese una palabra: ");
        int longitud; // Importante declarar la variable fuera del ciclo do while, porque sino me da error.
        do{
            palabra = scanf.nextLine();
            longitud = palabra.length();
            if(longitud > 25){
                System.out.println("Palabra ingresada es muy larga, ingrese nuevamente.");
            }
        }while(longitud > 25);
        scanf.close();

        String palabraSinRepetir = eliminarLetrasRepetidas(palabra);
        palabraSinRepetir = palabraSinRepetir.toUpperCase();
        longitud = palabraSinRepetir.length();
        // Asignacion palabra dentro de la matriz
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(posicion < longitud){
                    matriz[i][j] = palabraSinRepetir.charAt(posicion);
                    posicion++;
                } else{
                    matriz[i][j] = 'X';
                }
            }
        }
        imprimirMatriz(matriz);
    }

    // Funcion para eliminar las letras repetidas de la palabra (HASH)
    public static String eliminarLetrasRepetidas(String palabra){
        // Creamos un HashSet para almacenar caracteres únicos.
        HashSet<Character> caracteresUnicos = new HashSet<>();
        // Creamos un StringBuilder para construir la palabra sin caracteres repetidos (aqui se guardara).
        StringBuilder PalabraSinRepetidos = new StringBuilder();
        // Iteramos a través de cada caracter en la palabra ingresada.
            for(int i = 0; i < palabra.length(); i++){
                // Obtenemos el caracter en la posición actual.
                char letra = palabra.charAt(i);
                // Verificar si el caracter ya está en el HashSet.
                if(!caracteresUnicos.contains(letra)){
                    // Si no está en el HashSet, lo agregamos para indicar que ya lo hemos encontrado.
                    caracteresUnicos.add(letra);
                    // Agregamos el caracter al StringBuilder para construir la palabra sin letras repetidas.
                    PalabraSinRepetidos.append(letra);//El método append() es una función que se utiliza para agregar o concatenar texto, caracteres o datos a un objeto StringBuilder.
                }
            }
            // Retornar palabra sin caracteres repetidos.
            return PalabraSinRepetidos.toString();
    }

    public static void imprimirMatriz(char[][] matriz){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print("[" + matriz[i][j] + "]"); //el print debe ser sin la terminacion "ln" para que quede sin salto de linea.
            }
            System.out.println(" ");
        }
    }
}
