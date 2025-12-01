package _casino.HiLo;

import _casino.Player;
import java.util.*;
import java.io.*;

public class HiLo {
    private Player player;
    public HiLo(Player player) {
        this.player = player;
    }


    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("HiLo");
        System.out.println("----------------------------");
        System.out.print("Welcome! Please enter the upper bound (highest number possible) >> ");
        int upperBound = sc.nextInt();
        System.out.print("Please enter the lower bound (lowest number possible) >> ");
        int lowerBound = sc.nextInt();
        Random rand = new Random();
        int secretNumber = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;


        System.out.print("How many guesses would you like? >> ");
        int maxGuesses = sc.nextInt();
        if (maxGuesses > 10 || maxGuesses < 5) {
            System.out.println("Guesses must be between 5 and 10!");
        }

        System.out.println("Current balance: $" + player.getBalance());
        System.out.print("Please enter the amount you would like to bet: >> ");
        double bet = sc.nextDouble();
        double payout = bet * 2;
        if (player.getBalance() < bet) {
            System.out.println("You don't have enough money!");
            return;
        }
        System.out.println("You bet: $" + bet);

        boolean correct = false;

        while (!correct && maxGuesses > 0) {
            System.out.print("Take a guess! What's the number? >> ");
            int guess = sc.nextInt();
            if (guess < secretNumber) {
                System.out.println("Guess was too low!");
                maxGuesses--;
                System.out.println("You have " + maxGuesses + " guesses remaining. \n");
            } else if (guess > secretNumber) {
                System.out.println("Guess was too high!");
                maxGuesses--;
                System.out.println("You have " + maxGuesses + " guesses remaining. \n");
            } else {
                System.out.println("Yes! You guessed correctly! The number was indeed " + secretNumber + ". \n");
                correct = true;
                player.addMoney(payout);
                System.out.println("Deposited $" + payout + " into your bank. \n");


            }
        }
            if (!correct) {
                System.out.println("Out of guesses! Better luck next time! The number was " + secretNumber + ". \n");
                player.subtractMoney(bet);
            }

            player.saveBalance();

            System.out.println("Your new balance is $" + player.getBalance() + ". \n");
            System.out.print("Would you like to play again? Y/N >> ");
            String playAgain = sc.next();
            if (playAgain.equalsIgnoreCase("Y")) {
                start();
            } else if (playAgain.equalsIgnoreCase("N")) {
                System.exit(0);
            }

    }
}
