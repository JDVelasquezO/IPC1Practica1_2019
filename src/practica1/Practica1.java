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
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner out = new Scanner(System.in);
        
        System.out.println("Bienvenido a Guerra Naval");
        System.out.println("Selecciona una opción:");
        System.out.println("1. Jugar");
        System.out.println("2. Historial de partidas");
        System.out.println("3. Puntuaciones mas altas");
        System.out.println("4. Mayores aciertos y fallos");
        System.out.println("5. Ranking de ganadores");
        System.out.println("6. Informción");
        System.out.println("7. Salir");
        int opc = out.nextInt();
        
        if (opc == 1) {
            game(out);
        } else if (opc == 2) {
            System.out.println("Historial");
        } else if (opc == 3) {
            //puntuacionesAltas();
            System.out.println("Puntuaciones altas");
        } else if (opc == 4) {
            //aciertosFallos();
            System.out.println("Aciertos y fallos");
        } else if (opc == 5) {
            //rankingGanadores();
            System.out.println("Ranking");
        } else if (opc == 6) {
            info();
        } else if (opc == 7) {
            System.out.print(0);
        }
    }
    
    public static void game(Scanner out) {
        /*Inicio de juego*/
        System.out.println("Bienvenido al juego");
        int n = Coordinate.size(); // Se pide tamaño del tablero
        System.out.println("Ingresa el nombre del jugador 1: ");
        String player1 = out.next();
        System.out.println("Ingresa el nombre del jugador 2: ");
        String player2 = out.next();
        
        Player p1 = new Player(player1);
        Player p2 = new Player(player2);
        String p1Name = p1.name;
        String p2Name = p2.name;
        
        int nFilas = n;
        int nCols = n;
        
        // Creacion de tableros
        String toAttack[][] = new String[n][n];
        String toAttack2[][] = new String[n][n];
        String toRecevie[][] = new String[n][n];
        String toReceive2[][] = new String[n][n];
        
        // Establecer ambos tableros
        Board tab1 = new Board(nFilas, nCols, toAttack);
        Board tabTurno1 = new Board(nFilas, nCols, toRecevie);
        tab1.setBoard(nFilas, nCols, toAttack);
        tabTurno1.setBoard(nFilas, nCols, toRecevie);
        
        Board tab2 = new Board(nFilas, nCols, toAttack2);
        Board tabTurno2 = new Board(nFilas, nCols, toReceive2);
        tab2.setBoard(nFilas, nCols, toAttack2);
        tabTurno2.setBoard(nFilas, nCols, toReceive2);
        
        // Pedir coordenadas al primer usuario
        System.out.println("Tablero de " + p1Name);
        Board.drawBoard(toRecevie, toAttack, toRecevie.length);
        gameShip(toRecevie, toAttack2);
        pause();
        
        // Pedir coordenadas al segundo usuario
        System.out.println("Tablero de " + p2Name);
        Board.drawBoard(toReceive2, toAttack2, toReceive2.length);
        gameShip(toReceive2, toAttack);
        pause();
        
        // Comienza el juego
        // Saltos de linea
        for (int i=0;i<20;i++) {
            System.out.println();
        }

        double anyPlayer = Math.random(); // Escoge que jugador va a iniciar

        // Indica si se acabó un turno
        boolean gameFinished = false; 

        // Punteo de cada jugador
        int score1 = p1.punteo; 
        int score2 = p2.punteo;

        // Aciertos
        int hits1 = 0;
        int hits2 = 0;

        // Fallos
        int fails1 = 0;
        int fails2 = 0;
        
        // Verificamos cuantos barcos hay
        int shipsP1 = Register.numberBoats(toRecevie, 0);
        int shipsP2 = Register.numberBoats(toReceive2, 0);  
        
        // Si no ha finalizado el juego...
        while (!gameFinished){
            // Si el número random está entre 0 y 0.5...
            if (anyPlayer >= 0.0 && anyPlayer <=0.5 && shipsP1 != 0){
                shifts(shipsP2, anyPlayer, toAttack2, toRecevie, toReceive2, p1Name, score1);
                anyPlayer = 0.8;
            }
            if (anyPlayer > 0.5 && anyPlayer <= 1.0 && shipsP2 != 0) {
                shifts(shipsP1, anyPlayer, toAttack, toRecevie, toReceive2, p2Name, score2);
                anyPlayer = 0.2;
            }
            if (score1 <= 0 || shipsP1 == 0){
                score(p2Name, score2, p1Name, score1, hits1, fails1, hits2, fails2, toAttack, 
                toAttack2, gameFinished);
            } else if (score2 <= 0 || shipsP2 == 0){
                score(p1Name, score1, p2Name, score2, hits2, fails2, hits1, fails1, toAttack2, 
                toAttack, gameFinished);
            }
        }
    }

    public static void shifts(int ships, double anyPlayer, String[][] toAttack, String[][] toRecevie, 
            String[][] toReceive2, String pName, int score ) {
        
        Board.drawBoard(toAttack, toReceive2, toAttack.length);
        System.out.println("\nTurno de" + pName+"\n");
        score = score + Ship.shot(toRecevie, toAttack);
        Board.drawBoard(toAttack, toReceive2, toAttack.length);
        pause();
        for (int i=0;i<20;i++){System.out.println("\n");}
        ships = Register.numberBoats(toRecevie, 0);
    }

    public static void score(String p2Name, int score2, String p1Name, int score1, int hits1, int fails1, 
    int hits2, int fails2, String[][] toAttack, String[][] toAttack2, boolean gameFinished) {
        System.out.println("El ganador es " + p2Name + " con " + score2 +" puntos");
        System.out.println("El perdedor es " + p1Name + " con " + score1 +" puntos");
        hits1 = Register.numberFails( toAttack2, Style.RED+"X"+Style.RESET+"");
        fails1 = Register.numberHits( toAttack2, Style.BLU+"O"+Style.RESET+"");
        hits2 = Register.numberFails( toAttack, Style.RED+"X"+Style.RESET+"");
        fails2 = Register.numberHits( toAttack, Style.BLU+"O"+Style.RESET+"");
        History.sendToHistory(p2Name, score2, hits2 , fails2, p1Name, score1, hits1, fails1, toAttack);
        gameFinished = true;
    }
    
    public static void pause() {
        System.out.println("Presiona enter para continuar...");
        String entrada  = "";
        Scanner scanner = new Scanner(System.in);
         do{
             entrada = scanner.nextLine();
             System.out.println(entrada);
         }
         while(!entrada.equals(""));
    }
    
    public static void gameShip(String tab1[][], String tab2[][]) {
        System.out.println("\n Debes ingresar 1 barco de 4 casilla");
        Ship.setShips(tab1, 4);
        Board.drawBoard(tab1, tab2, tab1.length);
        
        System.out.println("\n Debes ingresar 2 barcos de 3 casillas");
        for (int b = 1; b <= 2; b++) {
            System.out.println("Barco # " + b);
            Ship.setShips(tab1, 3);
            Board.drawBoard(tab1, tab2, tab1.length);
        }
        System.out.println("\nDebes ingresar 3 barcos de 2 casillas");
        for (int b = 1; b <= 3; b++) {
            System.out.println("Barco #" + b);
            Ship.setShips(tab1, 2);
            Board.drawBoard(tab1, tab2, tab1.length);
        }
        System.out.println("\nDebes ingresar 1 barco de 4 casillas");
        for (int b = 1; b <= 4; b++) {
            System.out.println("Barco #" + b);
            Ship.setShips(tab1, 1);
            Board.drawBoard(tab1, tab2, tab1.length);
        }
    }
    
    public static void info() {
        System.out.println("201800722");
        System.out.println("José Daniel Velásquez Orozco");
        System.out.println("Introducción a la programación y Computación 1");
        System.out.println("Sección C");
        System.out.println("¯\\_(ツ)_/¯");
    }
}
