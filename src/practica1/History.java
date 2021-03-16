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
class History {
    public static void sendToHistory(String winner, int scoreP1, int hitsP1, int failsP1, 
    String loser, int scoreP2,int hitsP2, int failsP2, String board[][]) {
        System.out.println("Tablero de tamaño: " + board.length);
        System.out.println("El ganador es: " + winner + ". El perdedor es: " + loser);
        dataPlayers(winner, scoreP1, hitsP1, failsP1);
        dataPlayers(loser, scoreP2, hitsP2, failsP2);
    }

    public static void dataPlayers(String player, int stats, int hits, int fails) {
        System.out.println(player + " obtuvo " + stats + " puntos ");
        System.out.println(player + " obtuvo " + fails + " fallos ");
        System.out.println(player + " obtuvo " + hits + " aciertos ");
    }
}