/*
 * The Card class represents a playing card with a rank and suit. 
 * There are methods to compare card values.
 * @author Team rEach4help
 * UTSA CS 3443 - Team Project
 * Fall 2021
 */
package application.model;

public class Card {
	/*Ranks:
   2-10: Corresponding integer
	  1: Ace
	 11: Jack
	 12: Queen
	 13: King
	 */
	private int rank;
	/*Suits:
	 0: Clubs
	 1: Diamonds
	 2: Hearts
	 3: Spades
	 */
	private int suit;
	//Card constructor
	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	/*toString() returns a String representation of a card
	 * @return: String
	 */
	public String toString() {
		String[] ranks = {null, "Ace", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "Jack", "Queen", "King" };
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		return ranks[this.rank] + " of " + suits[this.suit];
		}
	/*equals() returns a boolean denoting if two cards were equal or not
	 * @return: boolean, 1 if the cards were equal, 0 if the cards were not equal
	 */
	public boolean equals(Card other) {
		return this.rank == other.rank && this.suit == other.suit;
	}
	/*compare() compares cards to see which has a larger value
	 * Compares suits first, returning -1 if the other card is larger,
	 * or 1 if the user card is larger.
	 * Compares ranks second, returning -1 if the other card is larger,
	 * or 1 if the user card is larger.
	 * Return 0 if the cards are equal
	 * @return: int
	 */
	public int compare(Card other) {
		if(this.suit < other.suit) 
			return -1;
		
		if(this.suit > other.suit)
			return 1;
		if(this.rank < other.rank) 
			return -1;
		
		if(this.rank > other.rank)
			return 1;
	
		return 0;
	}
	/*getRank() gets the rank of a Card
	 * @return int
	 */
	public int getRank() {
		return this.rank;
	}
	/*setRank() sets the rank of a Card
	 * @param int
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	/*getSuit() gets the suit of a Card
	 * @return int
	 */
	public int getSuit() {
		return this.suit;
	}
	/*setRank() sets the suit of a Card
	 * @param int
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}
}