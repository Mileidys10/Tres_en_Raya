/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eltriqui;


import java.util.*;
public class ElTriqui {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int jugadas = 0;
    int x = 0,o=1;
    
        int[][] tabla = new int[3][3];
        tabla [0][0]=1;
        tabla [0][1]=2;
        tabla [0][2]=3;
        tabla [1][0]=4;
        tabla [1][1]=5;
        tabla [1][2]=6;
        tabla [2][0]=7;
        tabla [2][1]=8;
        tabla [2][2]=9;
        
        String[][] tabla2 = new String[3][3];
        tabla2 [0][0]=1+"";
        tabla2 [0][1]=2+"";
        tabla2 [0][2]=3+"";
        tabla2 [1][0]=4+"";
        tabla2 [1][1]=5+"";
        tabla2 [1][2]=6+"";
        tabla2 [2][0]=7+"";
        tabla2 [2][1]=8+"";
        tabla2 [2][2]=9+"";
        
        System.out.println("Bienvenido al juego del triqui");
        System.out.println("Primero empieza la X y luego el O");
        

       
        do {            
            jugadas++;
            System.out.println("Ingrese el numero de la casilla en la cual va jugar" ); 
            
            mostrarTabla(tabla2);
                 int num = sc.nextInt();
    if (jugadas % 2 == 0) {
        System.out.println("Turno de X");
        asignacionCasillaO(tabla, num, o, tabla2);
    } else {
        System.out.println("Turno de O");
        asignacionCasillaX(tabla, num, x, tabla2);
    }
    
    if (verificarGanador(tabla2)) {
        if (jugadas % 2 == 0) {
            System.out.println("¡Felicidades! ¡El jugador O ha ganado!");
        } else {
            System.out.println("¡Felicidades! ¡El jugador X ha ganado!");
        }
                mostrarTabla(tabla2);

        break;
    }
            
        } while (jugadas<=9);
        if (jugadas > 9 && !verificarGanador(tabla2)) {
    System.out.println("¡Empate! ¡Ningún jugador ha ganado!");
    mostrarTabla(tabla2); // Mostrar el tablero final
}
        
        
        
    }
    static void mostrarTabla(String m[][]){
    String red = "\033[31m";
    String cyan = "\033[36m";
    String reset = "\u001B[0m";

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (m[i][j].equals("O")) {
                System.out.print(red + "[" + m[i][j] + "]" + reset);
            } else if (m[i][j].equals("X")) {
                System.out.print(cyan + "[" + m[i][j] + "]" + reset);
            } else {
                System.out.print("[" + m[i][j] + "]");
            }
        }
        System.out.println("");
    }
}

    static void asignacionCasillaX(int s[][],int num,int x,String r [][]){
    for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s[i][j]==num) {
                    r[i][j]= "X";
                    
                }
            }
    }


}
    static void asignacionCasillaO(int s[][],int num,int o,String r [][]){
    for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s[i][j]==num) {
                     r[i][j]= "O";
                }
            }
    }


}
static boolean verificarGanador(String[][] tabla) {
    // Verificar filas
    for (int i = 0; i < 3; i++) {
        if (tabla[i][0].equals(tabla[i][1]) && tabla[i][0].equals(tabla[i][2])) {
            return true;
        }
    }

    // Verificar columnas
    for (int j = 0; j < 3; j++) {
        if (tabla[0][j].equals(tabla[1][j]) && tabla[0][j].equals(tabla[2][j])) {
            return true;
        }
    }

    // Verificar diagonales
    if ((tabla[0][0].equals(tabla[1][1]) && tabla[0][0].equals(tabla[2][2])) ||
        (tabla[0][2].equals(tabla[1][1]) && tabla[0][2].equals(tabla[2][0]))) {
        return true;
    }

    return false;
}

}