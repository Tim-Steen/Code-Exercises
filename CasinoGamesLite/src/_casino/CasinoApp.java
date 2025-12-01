/* MAIN MENU, THIS MUST HANDLE GAME SELECTION! */
package _casino;
import _casino.Blackjack.Blackjack;
import _casino.CoinFlip.CoinFlip;
import _casino.Colorwheel.Colorwheel;
import _casino.HiLo.HiLo;
import _casino.Player;

import java.awt.*;
import java.util.*;

public class CasinoApp {

    public static void intro() {
        Player player = new Player("Zel", 500);
        player.loadBalance();

        //Queue<Object> queue = new Queue<>();
        //queue.add("1. CoinFlip");

        System.out.println("1. CoinFlip");
        System.out.println("2. HiLo");
        System.out.println("3. Blackjack");
        System.out.println("4. Colour Wheel");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1) {
            CoinFlip coin = new CoinFlip(player);
            coin.start();
        } else if (choice == 2) {
            HiLo hilo = new HiLo(player);
            hilo.start();
        } else if (choice == 3) {
            Blackjack blackjack = new Blackjack(player);
            blackjack.start();
        } else if (choice == 4) {
            Colorwheel colorwheel = new Colorwheel(player);
            colorwheel.start();
        }
        player.saveBalance();
    }

    public static void main(String[] args) {
        intro();


    }
}