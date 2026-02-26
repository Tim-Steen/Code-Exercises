package _casino.Blackjack;

import java.util.Random;

public class Card {
    private final int RANK, SUIT;
    private static final Random GENERATOR = new Random();
    private static final String[] Ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final String[] Suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Card() {
        RANK = GENERATOR.nextInt(Ranks.length);
        SUIT = GENERATOR.nextInt(Suits.length);
    }

    public String getRank() {
        return Ranks[RANK];
    }
    public String getSuit() {
        return Suits[SUIT];
    }
    public int getRankValue() {
        return RANK;
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }


       /* ALT METHOD:
        if (this.getRankValue() > otherCard.getRankValue()) return 1;
        else if (this.getRankValue() < otherCard.getRankValue()) return -1;
        else return 0;*/
    }


