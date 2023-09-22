import java.util.Scanner;

public class palabraPalindroma {
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);
        System.out.println("Ingrese una palabra para verificar si es palindroma");
        String palabra = scanf.nextLine();
        scanf.close();
        //Llamado de funcion para verificar si es palindroma
        if(esPalindromo(palabra)){
            System.out.println("Palabra ingresada SI es palindroma");
        } else{
            System.out.println("Palabra ingresada NO es palindroma");
        }
    }

    public static boolean esPalindromo(String palabra){
        String palabraMayus = palabra.toUpperCase();
        int longitud = palabra.length();
        //Comparar caracteres de la palabra
        for(int i = 0; i < (longitud/2); i++){
            if(palabraMayus.charAt(i) != palabraMayus.charAt(longitud - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
