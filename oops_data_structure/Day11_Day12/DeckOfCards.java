import java.util.Random;

public class DeckOfCards {

    public static void main(String[] args) {

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        String[] deck = new String[52];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        shuffleDeck(deck);

        String[][] players = new String[4][9];

        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < 9; j++) {
                System.out.println(players[i][j]);
            }
        }
    }

    private static void shuffleDeck(String[] deck) {
        Random random = new Random();

        for (int i = 0; i < deck.length; i++) {
            int randomIndex = random.nextInt(deck.length);

            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }
}

