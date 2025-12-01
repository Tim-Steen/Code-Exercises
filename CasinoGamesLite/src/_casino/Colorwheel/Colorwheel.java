package _casino.Colorwheel;

import _casino.Player;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Colorwheel {

    private Player player;
    public Colorwheel(Player player) {
        this.player = player;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Colour wheel of Fortune");
        System.out.println("----------------------");
        double bet = 0;
        boolean valid = false;

        System.out.println("Current balance: $" + player.getBalance());

        System.out.println("The wheel is as follows: Red > Black > Blue > Yellow > Black > Red > Purple > Purple > Black > Red > Yellow > Purple.");
        System.out.println("Red: 25%   Black: 25%   Blue: 9%   Purple: 25%   Yellow: 16%");

        while (!valid) {
            System.out.print("How much do you want to bet? >> ");
            try {
                bet = sc.nextDouble();
                sc.nextLine();
                if (bet <= 0)  {
                    System.out.println("Bet should be a positive number!");
                } else if (bet > player.getBalance()) {
                    System.out.println("You don't have enough money!");
                } else  {
                    valid = true; // this can tell me that if the above is satisfied, the user has given good input
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
            }
        }


        double payout = bet * 2;
        if (player.getBalance() < bet) {
            System.out.println("You don't have enough money!");
            return;
        }
        System.out.print("What colour do you wish to pick? >> ");
        String colour = sc.next();

        String[] colours = {"Red", "Black", "Blue", "Yellow", "Black", "Red", "Purple", "Purple", "Black", "Red", "Yellow", "Purple"};
        // 3 reds, 3 blacks, 3 purples, 2 yellows, 1 blue
        // 5 colours.
        Random rand = new Random();


       /** switch (colour) {
            case "Red" -> System.out.println("You chose red.");
            case "Black" -> System.out.println("You chose black.");
            case "Green" -> System.out.println("You chose green.");
            case null, default -> System.out.println("Invalid colour.");
        } **/

        String randomColour = colours[rand.nextInt(colours.length)]; // Here I have it pick at random a colour.

        boolean colourMatches = false; // helps with debugging
        // Win/Loss logic; don't want it to fail on the answer being lowercase so I'll have equalsignorecase
        if (randomColour.equalsIgnoreCase(colour)) {
            colourMatches = true;
            System.out.println("Well done! The wheel landed on " +randomColour);

            if (randomColour.equals("Yellow") && randomColour.equalsIgnoreCase(colour)) {
                payout = bet * 2.5;
                System.out.println("Bonus deposit of " + bet * 2.5 + " (2.5x) for uncommon colour!");
                System.out.println("\nDepositing $" + payout + " into your bank.");
                System.out.println("DEVELOPER NOTE: Payout is currently " + payout);
                player.addMoney(payout);

            } else if (randomColour.equals("Blue") && randomColour.equalsIgnoreCase(colour)) {
                payout = bet * 5;
                System.out.println("Bonus deposit of " + bet * 5 + " (5x) for rarest colour!");
                System.out.println("\nDepositing $" + payout + " into your bank.");
                System.out.println("DEVELOPER NOTE: Payout is currently " + payout);
                player.addMoney(payout);

            } else if (randomColour.equals("Black") || (randomColour.equals("Red") || (randomColour.equals("Purple"))) && randomColour.equalsIgnoreCase(colour)) {
                System.out.println("Normal deposit amount (2x) given!");
                System.out.println("\nDepositing $" + payout + " into your bank.");
                System.out.println("DEVELOPER NOTE: Payout is currently " + payout);
                player.addMoney(payout);
            }

         //   player.addMoney(payout);

        } else {
            System.out.println("Unlucky! The wheel landed on " + randomColour);
            System.out.println("\nSubtracting $" + bet + " from your bank.");
            player.subtractMoney(bet);
        }

        player.saveBalance();
        System.out.println("Your new balance is $" + player.getBalance());

        valid = false;


        while (!valid) {
            System.out.print("\nDo you want to play again? Y/N >> ");
            try {
                String playAgain = sc.next();
                if (playAgain.equalsIgnoreCase("Y")) {
                    start();
                } else if (playAgain.equalsIgnoreCase("N")) {
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                } else {
                    System.out.println("Please enter a valid option!");
                }
            } catch (Exception ex) {
                System.out.println("Please enter a valid option!");
            }
        }


    }

}
