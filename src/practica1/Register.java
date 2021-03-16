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
class Register {
    public static int numberBoats(String matriz[][], int start) {
        int numberof = start;
        for (int v = 0; v < matriz.length; v++) {
            for (int h = 0; h < matriz.length; h++) {
                if (matriz[v][h] == "■")
                    numberof++;
            }
        }
        return numberof;
    }

    public static int numberHits(String matriz[][], String character) {
        int numberof = 0;
        for (int v = 0; v < matriz.length; v++) {
            for (int h = 0; h < matriz.length; h++) {
                if (matriz[v][h] == Style.RED+"X"+Style.RESET)
                    numberof++;
            }
        }
        return numberof;
    }

    public static int numberFails(String matriz[][], String character) {
        int numberof = 0;
        for (int v = 0; v < matriz.length; v++) {
            for (int h = 0; h < matriz.length; h++) {
                if (matriz[v][h] == Style.BLU+"O"+Style.RESET)
                    numberof++;
            }
        }
        return numberof;
    }
}
