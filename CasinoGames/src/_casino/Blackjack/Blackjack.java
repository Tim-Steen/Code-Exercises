package _casino.Blackjack;

import _casino.Player;


import java.util.*;

public class Blackjack {
    private Player player;
    public Blackjack(Player player) {
        this.player = player;
    }

  /*  public static void bubbleSort(Card[] myCards) {
        for (int i = 0; i < (myCards.length -1); i++) {
            for (int j = 0; j < (myCards.length -i - 1); j++) {
                if (myCards[j].getRankValue() > myCards[j + 1].getRankValue()) {
                    Card temp = myCards[j];
                    myCards[j] = myCards[j + 1];
                    myCards[j + 1] = temp;
                }
            }
        }
    } */

    public void start() {
        List<String> playerHand = new ArrayList<>();
        List<String> dealerHand = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Blackjack");
        System.out.println("----------------------------------");
        System.out.println("Current balance: $" + player.getBalance());

        System.out.print("How much do you wish to bet? >> ");
        double bet = sc.nextDouble();

        String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        // String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

        playerHand.add(drawCard(cards));
        playerHand.add(drawCard(cards));
        dealerHand.add(drawCard(cards));
        dealerHand.add(drawCard(cards));

        System.out.println("Dealer's hand: " + dealerHand.getFirst() + " + ?");
        System.out.println("Player's hand: " + playerHand + " (" + handValue(playerHand) + ")");

        // PLAYER
        boolean playerChoseStand = false;
        while (!playerChoseStand && handValue(playerHand) < 21) {
            System.out.println("What would you like to do?");
            System.out.println("Press 1 to hit.");
            System.out.println("Press 2 to stand.");
            int choice = sc.nextInt();
            if (choice == 1) {
                playerHand.add(drawCard(cards));
                System.out.println("You drew a " + playerHand.get(playerHand.size() - 1));
                System.out.println("Your new hand is " + playerHand + " (" + handValue(playerHand) + ")");
            } else if (choice == 2) {
                playerChoseStand = true;

            } else {
                System.out.println("Invalid choice.");
            }
        }
        int playerTotal = handValue(playerHand);
        if (playerTotal > 21) {
            System.out.println("BUST! You exceeded 21 in card values.");
            player.subtractMoney(bet);
            System.out.println("Your new balance is $" + player.getBalance());
            return;
        }

        System.out.println("Dealer's go...");
        System.out.println("Dealer's hand: " + dealerHand + " (" + handValue(dealerHand) + ")");

        while (handValue(dealerHand) < 17) {
            dealerHand.add(drawCard(cards));
            System.out.println("Dealer drew a " + dealerHand.get(dealerHand.size() - 1));
            System.out.println("Dealer's new hand is " + dealerHand + " (" + handValue(dealerHand) + ")");
        }
        int dealerTotal = handValue(dealerHand);

        System.out.println("DETERMINING WINNER!");
        System.out.println("Your hand: " + playerHand + " (" + playerTotal + ")");
        System.out.println("Dealer's hand: " + dealerHand + " (" + dealerTotal + ")");

        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("You win!");
            double payout = bet * 2;
            System.out.println("Depositing $" + payout + " into your bank.");
            player.addMoney(payout);
            System.out.println("Your new balance is $" + player.getBalance());
        } else if (playerTotal < dealerTotal) {
            System.out.println("You lost!");
            player.subtractMoney(bet);
            System.out.println("Your new balance is $" + player.getBalance());
        } else {
            System.out.println("Wow, it's a tie!");
        }
    }

    private String drawCard(String[] cards) {
        return cards[new Random().nextInt(cards.length)];

    }

    public int handValue(List<String> hand) {
        int total = 0;
        int aces = 0;

        for (String card : hand) {
            switch (card) {
                case "Jack": case "Queen": case "King":
                    total += 10;
                    break;
                case "Ace":
                    aces++;
                    total += 11;
                    break;

                    default:
                        total += Integer.parseInt(card);
                        break;
            }
        }
        return total;
    }


}