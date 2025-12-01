package _casino.CoinFlip;

import _casino.Player;
import java.util.Scanner;

public class CoinFlip
{
    private Player player;
    public CoinFlip(Player player) {
        this.player = player;
    }
    public void start() {
        System.out.println("---------------------------------------------------");
        System.out.println("Starting CoinFlip");
        System.out.println("Current balance: $" + player.getBalance());
        System.out.print("What amount would you like to coin? >> ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        if (!player.subtractMoney(amount)) {
            System.out.println("You don't have enough money!");
            return;
        }
        System.out.println("You bet " + amount + " !");

        System.out.print("Heads or tails? >> ");
        String choice = sc.next();
        String result = Math.random() < 0.5 ? "heads" : "tails"; // Heads is 0 and Tails is 1.
        System.out.println("The coin landed on " + result + "!");

        if(choice.equalsIgnoreCase(result)) {
            double payout = amount * 1.5;
            player.addMoney(payout);
            System.out.println( "Congratulations! You guessed correctly. You won $" + payout + "!");
        }else {
            System.out.println("Better luck next time!");
        }
        player.saveBalance();

        System.out.println("Your new balance is $" + player.getBalance());

        System.out.print("Do you wish to play again? Y/N >> ");
        String yesno = sc.next();
        if (yesno.equalsIgnoreCase("Y")) {
            start();
        } else {
            System.exit(0);
        }

    }

}