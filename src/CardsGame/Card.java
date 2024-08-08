package CardsGame;

import java.util.ArrayList;
import java.util.List;

/**
 * This record represents a card.
 * @param suit The suit the card.
 * @param face The face of the card.
 * @param rank The rank of the card.
 */
public record Card(Suit suit, String face, int rank) {
    /**
     * This enum represents the suits of the cards.
     */
    public enum Suit{
        CLUB, DIAMOND, HEART, SPADE;

        /**
         * This method gets the image for every suit.
         * @return The image of every suit according to its decimal code.
         */
        public char getImage(){
            return (new char[] {9827, 9830, 9829, 9824})[this.ordinal()];
        }
    }

    /**
     * This method shows a card.
     * @return The way that a card is shown.
     */
    @Override
    public String toString() {
        int index = face.equals("10") ? 2 : 1;
        String faceString = face.substring(0, index);
        return "%s%c(%d)".formatted(faceString, suit.getImage(), rank);
    }

    /**
     * Creates a numeric card.
     * @param suit The suit of the card.
     * @param cardNumber The number of the card (between 2 and 10 inclusive).
     * @return A new card.
     */
    public static Card getNumericCard(Suit suit, int cardNumber){
        if (cardNumber > 1 && cardNumber < 11){
            return new Card(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        System.out.println("Invalid Numeric card selected");
        return null;
    }

    /**
     * Creates a face card.
     * @param suit The suit of the card.
     * @param abbrev The character of the card (J, Q, K, A).
     * @return A new card.
     */
    public static Card getFaceCard(Suit suit, char abbrev){
        int charIndex = "JQKA".indexOf(abbrev);
        if (charIndex > -1){
            return new Card(suit, ""+abbrev, charIndex + 9);
        }
        System.out.println("Invalid Face card selected");
        return null;
    }

    /**
     * Creates a standard deck of cards.
     * @return A list of a standard deck of 52 cards.
     */
    public static List<Card> getStandardDeck(){
        List<Card> deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()){
            for (int i = 2; i <= 10; i++){
                deck.add(getNumericCard(suit, i));
            }

            for (char c : new char[]{'J', 'Q', 'K', 'A'}){
                deck.add(getFaceCard(suit, c));
            }
        }
        return deck;
    }

    /**
     * Prints a deck of cards.
     * @param deck A list of cards.
     * @param description A description.
     * @param rows The number of rows in witch cards are displayed.
     */
    public static void printDeck(List<Card> deck, String description, int rows){
        System.out.println("----------------------------------");
        if (description != null){
            System.out.println(description);
        }

        int cardsInRow = deck.size() / rows;

        for (int i=0; i < rows; i++){
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c -> System.out.print(c + " "));
            System.out.println();
        }
    }

    /**
     * Prints the current deck with a default description, on 4 lines.
     * @param deck Deck of cards.
     */
    public static void printDeck(List<Card> deck){
        printDeck(deck, "Current Deck", 4);
    }
}
