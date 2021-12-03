/**
 * The Card class represents a playing card with a rank and suit. There are
 * methods to
 * compare card values.
 * 
 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
 * @author Kyle Anderson
 * @author Allison Clay
 * @author Alayna Richerson
 * @author John Weaver
 */
package application.model;

public class Card {

	/**
	 * Variable - Ranks: 2-10: Corresponding integer 1: Ace 11: Jack 12: Queen
	 * 13: King
	 */
	private int rank;

	/**
	 * Variable - Suits: 0: Clubs 1: Diamonds 2: Hearts 3: Spades
	 */
	private int suit;

	/**
	 * CONSTRUCTOR: Card creates the individual card from a normal deck of
	 * cards.
	 * 
	 * @author Team rEach4help UTSA CS 3443
	 * 
	 * @param rank
	 *     The number value 2 - 10 of the card.
	 * @param suit
	 *     The suit is either Clubs, Diamonds, Hearts, or Spades.
	 */
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public String toString() {
		String[] ranks = {null, "Ace", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "Jack", "Queen", "King"};
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		return ranks[this.rank] + " of " + suits[this.suit];
	}

	/**
	 * getCardImageName() returns the card image name as a string
	 * 
	 * @return cardImageName() Gets the specific card image.
	 */
	public String getCardImageName() {
		String[] ranks = {null, "ace", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "jack", "queen", "king"};
		String[] suits = {"clubs", "diamonds", "hearts", "spades"};
		return ranks[this.rank] + "_of_" + suits[this.suit] + ".png";
	}

	/**
	 * METHOD:equals() Returns a boolean denoting if two cards are equal or not
	 * equal.
	 * 
	 * @param other
	 *     An integer to determine which card wins.
	 * 
	 * @return this.rank Returns 1 if the cards are equal and 0 if the cards are
	 *     not equal.
	 */
	public boolean equals(Card other) {
		return this.rank == other.rank && this.suit == other.suit;
	}

	/**
	 * METHOD:compare() compares cards to see which has a larger value.
	 * First compares suits, returning -1 if the other card is larger, or 1 if
	 * the user card is larger.
	 * Secondly, compares ranks, returning -1 if the other card is larger, or 1
	 * if the user card is larger.
	 * Finally, returns 0 if the cards are equal.
	 * 
	 * @param other
	 *     An integer to determine which card wins.
	 * 
	 * @return other Determines which card wins.
	 */
	public int compare(Card other) {
		if (this.suit < other.suit)
			return -1;
		if (this.suit > other.suit)
			return 1;
		if (this.rank < other.rank)
			return -1;
		if (this.rank > other.rank)
			return 1;
		return 0;
	}

	/**
	 * getRank() gets the rank of a Card
	 * 
	 * @return this.rank Gives this card's numeric rank.
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * setRank() sets the rank of a Card
	 * 
	 * @param rank
	 *     Sets this card's numeric rank.
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * getSuit() Gives this card's suit (Clubs, Diamonds, Hearts, or Spades).
	 * 
	 * @return this.suit Gives this card's suit.
	 */
	public int getSuit() {
		return this.suit;
	}

	/**
	 * setRank() sets the suit of a Card
	 * 
	 * @param suit
	 *     Sets this card's suit (Clubs, Diamonds, Hearts, or Spades).
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}
}
