package CardsGame;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a player who plays a card game.
 */
public class Player {
    /**
     * The number from which the player counter starts.
     */
    private static int number = 0;

    /**
     * The player's id.
     */
    private int playerId;

    /**
     * List of player's cards.
     */
    private List<Card> playerCards;

    /**
     * The constructor.
     */
    public Player() {
        playerId = number++;
        this.playerCards = new ArrayList<>();
    }

    /**
     * This method gets the id of the player.
     * @return The player's id.
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * This method gets the player's list of cards.
     * @return The list of cards.
     */
    public List<Card> getPlayerCards() {
        return playerCards;
    }

    /**
     * This method display the player's list of cards.
     * @return The list of cards.
     */
    @Override
    public String toString() {
        return "" + playerCards;
    }
}
