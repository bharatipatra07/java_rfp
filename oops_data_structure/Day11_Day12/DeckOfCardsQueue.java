import java.util.Random;
class Card {

    String suit;
    String rank;
    int rankValue;

    public Card(String suit, String rank, int rankValue) {
        this.suit = suit;
        this.rank = rank;
        this.rankValue = rankValue;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
class CardNode {
    Card card;
    CardNode next;

    public CardNode(Card card) {
        this.card = card;
        this.next = null;
    }
}
class CardQueue {

    private CardNode front, rear;

    public void enqueue(Card card) {
        CardNode node = new CardNode(card);

        if (rear == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    public Card dequeue() {
        if (front == null) return null;

        Card card = front.card;
        front = front.next;

        if (front == null)
            rear = null;

        return card;
    }

    public void sortByRank() {
        for (CardNode i = front; i != null; i = i.next) {
            for (CardNode j = i.next; j != null; j = j.next) {
                if (i.card.rankValue > j.card.rankValue) {
                    Card temp = i.card;
                    i.card = j.card;
                    j.card = temp;
                }
            }
        }
    }

    public void printCards() {
        CardNode temp = front;
        while (temp != null) {
            System.out.println("   " + temp.card);
            temp = temp.next;
        }
    }
}
class Player {

    int playerId;
    CardQueue cards = new CardQueue();

    public Player(int playerId) {
        this.playerId = playerId;
    }

    public void addCard(Card card) {
        cards.enqueue(card);
    }

    public void sortCards() {
        cards.sortByRank();
    }

    public void showCards() {
        System.out.println("Player " + playerId + " cards:");
        cards.printCards();
    }
}
class PlayerNode {
    Player player;
    PlayerNode next;

    public PlayerNode(Player player) {
        this.player = player;
        this.next = null;
    }
}
class PlayerQueue {

    private PlayerNode front, rear;

    public void enqueue(Player player) {
        PlayerNode node = new PlayerNode(player);

        if (rear == null) {
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    public void printPlayers() {
        PlayerNode temp = front;
        while (temp != null) {
            temp.player.sortCards();
            temp.player.showCards();
            temp = temp.next;
            System.out.println();
        }
    }
}

public class DeckOfCardsQueue {

    public static void main(String[] args) {

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {
                "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "Jack", "Queen", "King", "Ace"
        };

        Card[] deck = new Card[52];
        int index = 0;

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                deck[index++] = new Card(suit, ranks[i], i + 2);
            }
        }

        shuffle(deck);

        PlayerQueue playerQueue = new PlayerQueue();

        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player(i + 1);
            playerQueue.enqueue(players[i]);
        }

        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i].addCard(deck[cardIndex++]);
            }
        }

        playerQueue.printPlayers();
    }

    private static void shuffle(Card[] deck) {
        Random random = new Random();

        for (int i = 0; i < deck.length; i++) {
            int r = random.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }
}
