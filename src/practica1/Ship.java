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
class Ship {

    public static int shot(String attacked[][], String attacker[][]) {
        int score = 0;
        System.out.println("\nDisparo: ");
        while(true) {
            int ir = Coordinate.row(attacked.length, 0);
            int ic = Coordinate.col(attacked.length, 0);
            
            String fail = Style.BLU + "O" + Style.RESET + "";
            String hit = Style.RED + "X" + Style.RESET + "";
            
            if (attacked[ir][ic] == fail || attacked[ir][ic] == hit) {
                System.out.println("\n" + Style.RED + "Aquí ya has disparado" + Style.RESET + "\n");
            }
            else if (attacked[ir][ic] == "■") {
                attacked[ir][ic] = hit;
                attacker[ir][ic] = hit;
                System.out.println("\n" + Style.CYAN + "Acabas de disparar" + Style.RESET + "\n");
                score = 50;
                break;
            } else {
                attacked[ic][ic] = fail;
                attacker[ir][ic] = fail;
                System.out.println("\n" + Style.CYAN + "No le diste" + Style.RESET + "\n");
                score = -5;
                break;
            }
        }
        return score;
    }

    public static void setShips(String matriz[][], int size) {
        int add = 0;

        int ir = 0;
        int ic = 0;
        int fr = 0;
        int fc = 0;

        switch (size) {
        case 2:
            add = 1;
            break;
        case 3:
            add = 2;
            break;
        case 4:
            add = 3;
            break;
        default:
            break;
        }
        
        while (true) {
            if (size == 1) {
                while (true) {
                    ir = Coordinate.row(matriz.length, 0);
                    ic = Coordinate.col(matriz.length, 0);
                    if (matriz[ir][ic] == "■") {
                        System.out.println("No se puede porque aquí ya hay un barco");
                    } else {
                        matriz[ir][ic] = "■";
                        break;
                    }
                }
            } else {
                ir = Coordinate.row(matriz.length, 0);
                ic = Coordinate.col(matriz.length, 0);
                fr = Coordinate.row(matriz.length, 1);
                fc = Coordinate.col(matriz.length, 1);
                
                boolean validation = validate(matriz, ir, ic, fr, fc, add);
                if (validation) {
                    set(matriz, ir, ic, fr, fc, add);
                    break;
                } else {
                    System.err.println("El tamaño es incorrecto o es diagonal");
                    System.out.println("Intente de nuevo: ");
                }
            }
        }
    }

    public static boolean validate(String matriz[][], int ir, int ic, int fr, int fc, int add) {
        boolean noOverlap = true;

        if (ir + add == fr || fr + add == ir) { // De arriba hacia abajo
            if (ic == fc) {
                for (int i = 0; i <= add; i++) {
                    if (ir + add == fr) {
                        if (matriz[ir + i][ic] == "■") {
                            System.out.println("No se puede porque aquí ya hay un barco");
                            noOverlap = false;
                        }
                    } else {
                        if (matriz[fr + i][ic] == "■") {
                            System.out.println("No se puede porque aquí ya hay un barco");
                            noOverlap = false;
                        }
                    }

                }
            }
        } else if (ic + add == fc || fc + add == ic) {
            if (ir == fr) {
                for (int i = 0; i <= add; i++) {
                    if (ic + add == fc) {
                        if (matriz[ir][ic + add] == "■") {
                            System.out.println("No se puede porque aquí ya hay un barco");
                            noOverlap = false;
                        }
                    } else {
                        if (matriz[fr][fc + add] == "■") {
                            System.out.println("No se puede porque aquí ya hay un barco");
                            noOverlap = false;
                        }
                    }

                }
            }
        }

        return noOverlap;
    }

    public static void set(String matriz[][], int ir, int ic, int fr, int fc, int add) {
        for (int i = 0; i <= add; i++) {
            if (ic + add == fc) {
                matriz[ir][ic + i] = "■"; // Horizontal
            } else if (fc + add == ic) {
                matriz[ir][fc + i] = "■";
            } else if (ir + add == fr) { // Vertical
                matriz[ir + i][fc] = "■";
            } else if (fr + add == ir) {
                matriz[fr + i][fc] = "■";
            }
        }
    }

    public static boolean overlapShip() {
        boolean isOverlaping = true;
        System.out.println("\n" + Style.RED + "Escoge otra posición, ésta ya está siendo usada por otro barco"
                + Style.RESET + "\n");
        return isOverlaping;
    }
}