/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.Scanner;

/**
 *
 * @author JD
 */
public class Coordinate {
    static Scanner out = new Scanner(System.in);
    
    public static int size() {
        int lim = 0;
        
        System.out.print("Escoge el tamaño del tablero de 10 a 26: ");
        do {
            while (!out.hasNextInt()) {
                System.out.print("\nDebes escribir un numero entero: ");
                System.out.print("\nIntenta de nuevo: ");
                out.nextLine();
            }
            
            lim = out.nextInt();
            if (lim < 10 || lim > 26) {
                System.out.print("\nEl lim del tablero está entre 10 y 26: ");
                System.out.print("\nIntenta de nuevo: ");
            }
            else
                break;
        } while (true);
        
        return lim;
    }

    public static int row(int lim, int pos) {
        
        String position = position(pos);
        
        String letter = "";
        int changuedLetter = 0;
        boolean condition = true;
        System.out.println("\nFila " + position + " (de la A a la " + converter(lim) + ")");
        do {
            letter = out.nextLine();
            
            switch (letter.toUpperCase()) {
                case "A":
                 changuedLetter = 0;
                    break;
                case "B":
                 changuedLetter = 1;
                    break;
                case "C":
                 changuedLetter = 2;
                    break;
                case "D":
                 changuedLetter = 3;
                    break;
                case "E":
                 changuedLetter = 4;
                    break;
                case "F":
                 changuedLetter = 5;
                    break;
                case "G":
                 changuedLetter = 6;
                    break;
                case "H":
                 changuedLetter = 7;
                    break;
                case "I":
                 changuedLetter = 8;
                    break;
                case "J":
                 changuedLetter = 9;
                    break;
                case "K":
                 changuedLetter = 10;
                    break;
                case "L":
                 changuedLetter = 11;
                    break;
                case "M":
                 changuedLetter = 12;
                    break;
                case "N":
                 changuedLetter = 13;
                    break;
                case "O":
                 changuedLetter = 14;
                    break;
                case "P":
                 changuedLetter = 15;
                    break;
                case "Q":
                 changuedLetter = 16;
                    break;
                case "R":
                 changuedLetter = 17;
                    break;
                case "S":
                 changuedLetter = 18;
                    break;
                case "T":
                 changuedLetter = 19;
                    break;
                case "U":
                 changuedLetter = 20;
                    break;
                case "V":
                 changuedLetter = 21;
                    break;
                case "W":
                 changuedLetter = 22;
                    break;
                case "X":
                 changuedLetter = 23;
                    break;
                case "Y":
                 changuedLetter = 24;
                    break;
                case "Z":
                 changuedLetter = 25;
                    break;
    
                default:
                 changuedLetter = 26;
                    break;
                }
            
            if (changuedLetter + 1 > lim) {
                System.out.println("Ingresa una letra: ");
            }
            else {
                condition = false;
            }
        } while (condition);
        
        return changuedLetter;
    }

    public static int col(int lim, int pos) {
        
        String position = position(pos);
        
        int number = 0;
        int index = 0;
        boolean condition = true;
        System.out.println("\nColumna " + position + " (1-" + lim + ")");
        System.out.print("Ingresa un numero: ");
        while (condition) {
            while (!out.hasNextInt()) {
                System.out.print("Ingresa un numero: ");
                out.nextLine();
            }
            number = out.nextInt();
            
            if (number == 1) {
                index = 0;
            } else if (number == 2) {
                index = 1;
            } else if (number == 3) {
                index = 2;
            } else if (number == 4) {
                index = 3;
            } else if (number == 5) {
                index = 4;
            } else if (number == 6) {
                index = 5;
            } else if (number == 7) {
                index = 6;
            } else if (number == 8) {
                index = 7;
            } else if (number == 9) {
                index = 8;
            } else if (number == 10) {
                index = 9;
            } else if (number == 11) {
                index = 10;
            } else if (number == 12) {
                index = 11;
            } else if (number == 13) {
                index = 12;
            } else if (number == 14) {
                index = 13;
            } else if (number == 15) {
                index = 14;
            } else if (number == 16) {
                index = 15;
            } else if (number == 17) {
                index = 16;
            } else if (number == 18) {
                index = 17;
            } else if (number == 19) {
                index = 18;
            } else if (number == 20) {
                index = 19;
            } else if (number == 21) {
                index = 20;
            } else if (number == 22) {
                index = 21;
            } else if (number == 23) {
                index = 22;
            } else if (number == 24) {
                index = 23;
            } else if (number == 25) {
                index = 24;
            } else if (number == 26) {
                index = 25;
            } else {
                index = 26;
            }

            if (index + 1 > lim)
                System.out.print("Ingresa un numero: ");
            else
                condition = false;
        }
        return index;
    }

    public static char converter(int number) {
        number = number + 64;
        char letter = (char) number;
        return letter;
    }
    
    public static String position(int pos) {
        String position = "";
        
        if (pos == 0) {
            position = "inicial";
        } else {
            position = "final";
        }
        
        return position;
    }
}
