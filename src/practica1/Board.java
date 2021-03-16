/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author JD
 */
public class Board {
    
    public String tablero[][];
    public int nFilas;
    public int nCols;
    
    public Board(int nFilas, int nCols, String tablero[][]) {
        this.tablero = tablero;
        this.nFilas = nFilas;
        this.nCols = nCols;
    }
    
    public void setBoard(int nFilas, int nCols, String tablero[][]) {
        for (int i = 0; i < nFilas; i++) {
            for (int j = 0; j < nCols; j++) {
                tablero[i][j] = "^";
            }
        }
    }
    
    public static void drawBoard(String matriz[][], String matriz2[][], int size) {
        int letters = 65;
        
        System.out.println("Aciertos y fallos: ");
        IterarorMatriz(size, matriz2, letters);
        
        letters = 65;
        
        System.out.println("Barcos: ");
        IterarorMatriz(size, matriz, letters);
    }
    
    public static void IterarorMatriz(int size, String[][] matriz, int letters) {
        System.out.print("  ");
        for ( int i = 1; i < size + 1; i++ ) {
            System.out.print(i);
            System.out.print(" ");
        }
        
        System.out.println(" ");
        for (int i = 0; i < matriz.length; i++) {
            
            char l = (char) letters;
            System.out.print(l);
            System.out.print(" ");
            
            for (int j = 0; j < matriz.length; j++) {
                System.out.print( matriz[i][j]);
                System.out.print(" ");
                
                if ( j >= 8 ) {
                    System.out.print(" ");
                }
            }
            letters ++;
            System.out.println(" ");
        }
    }
}
