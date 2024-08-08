package CardsGame;

import java.util.*;

/**
 * This class holds the functionality of the Crazy Eights Game.
 * The main objective of the game is to be the first player to get rid of all their cards.
 *
 * Setup:
 * 1. Use a standard 52-card deck.
 * 2. Shuffle the cards and deal 7 cards to each player.
 * 3. Place the remaining deck face down to create the draw pile. Turn the top card over and place it beside the draw pile to start the discard pile.
 *
 * Gameplay:
 * 1. Players take turns in a clockwise direction.
 * 2. On a player's turn, they must play a card that matches the rank (number) or suit of the top card on the discard pile.
 * 3. If a player cannot play a card, they must draw cards from the draw pile until they can.
 * 4. The exception is an "Eight" (8) card, which can be played at any time, and the player must declare a new suit.
 * 5. The game continues until a player has no cards left, signaling the end of the round.
 */
public class CrazyEightsGame{
    /**
     * A list of players.
     */
    private List<Player> players;
    /**
     * Lists of a standard deck of cards, played cards and remaining cards.
     */
    private List<Card> cards, playedCards, remainingCards;
    /**
     * The suite with which the card must match.
     */
    private Card.Suit suit;

    /**
     * The Random object used for generating random numbers.
     */
    private Random random;

    /**
     * The controller of the class.
     * The number of players must be maximum 7 because every player receives 7 cards.
     * @param playersNumber The number of players.
     */
    public CrazyEightsGame(int playersNumber) {
        if (playersNumber > 7){
            System.out.println("The number of players must be maximum 7!");
        } else {
            players = new ArrayList<>();

            for (int i = 0; i < playersNumber; i++){
                players.add(new Player());
            }

            cards = Card.getStandardDeck();
            suit = null;
            random = new Random();
        }
    }

    /**
     * This method shuffles the cards and deals 7 cards to each player.
     * It adds the first card of the rest of the deck to the played cards' list.
     * Then adds the rest of the cards to the remaining cards' list and starts the game.
     */
    public void playGame(){
        Collections.shuffle(cards);

        Card.printDeck(cards);
        System.out.println();

        for (Player player : players){
            for (int i = 0; i < 7; i++){
                player.getPlayerCards().add(cards.get(0));
                cards.remove(0);
            }
            System.out.println("Player no." + (player.getPlayerId()+1) + ": " + player.getPlayerCards());
            System.out.println();
        }

        playedCards = new ArrayList<>(List.of(cards.get(0)));
        remainingCards = new ArrayList<>(cards.subList(1, cards.size()));

        play();
    }

    /**
     * This method represents every player's turn.
     * It is called until one of them wins the game.
     */
    private void play(){
        System.out.println("Played cards: " + playedCards + "\n");
        System.out.println("Remaining cards: " + remainingCards + "\n");

        for (Player player : players){
            System.out.println("\nPlayer no. " + (player.getPlayerId()+1) + ": " + player.getPlayerCards());
            played(player);
        }

        Player winner = getWinner(players);
        if (winner!=null){
            System.out.println("\nThe winner is player no." + (winner.getPlayerId()+1));
        } else {
            play();
        }
    }

    /**
     * This method represents a player's turn.
     * It is called until he finds a card that matches.
     * @param player The player whose turn is.
     */
    private void played(Player player){
        changeCards();
        Card card = findCard(player);
        if (card != null){
            player.getPlayerCards().remove(card);
            playedCards.add(0, card);
        } else {
            player.getPlayerCards().add(remainingCards.get(0));
            remainingCards.remove(0);
            played(player);
        }
    }

    /**
     * Finds a card that matches the rank (number) or suit of the first card from the played cards list.
     * @param player The player whose turn is.
     * @return The card that matches.
     */
    private Card findCard(Player player){
        if (suit == null){
            for (Card card : player.getPlayerCards()){
                if (card.suit().equals(playedCards.get(0).suit()) || card.face().equals(playedCards.get(0).face()) || card.face().equals("8")){
                    if (card.face().equals("8")){
                        suit = getRandomSuit();
                    }
                    return card;
                }
            }
        } else {
            for (Card card : player.getPlayerCards()){
                if (card.suit().equals(suit)){
                    suit = null;
                    return card;
                }
            }
        }
        return null;
    }

    /**
     * If there are no remaining cards, it moves all played cards, except the first one, to the remaining cards list.
     * Shuffles the remaining cards.
     */
    private void changeCards(){
        if (remainingCards.size() == 0){
            remainingCards.addAll(playedCards.subList(1, playedCards.size()));
            playedCards.removeAll(remainingCards);
            Collections.shuffle(remainingCards);
        }
    }

    /**
     * Gets the winner of the game.
     * @param players The list of players.
     * @return The winner.
     */
    private Player getWinner(List<Player> players){
        for (Player player : players){
            if (player.getPlayerCards().size() == 0){
                return player;
            }
        }
        return null;
    }

    private Card.Suit getRandomSuit(){
        List<Card.Suit> suits = List.of(Card.Suit.values());
        int size = suits.size();
        return suits.get(random.nextInt(size));
    }
}
