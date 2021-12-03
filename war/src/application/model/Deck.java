/**
 * The Deck class represents a deck of cards.
 * The deck is made up of 52 playing cards.
 * There are methods for dealing cards, and removing cards from the deck.
 * 
 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
 * @author Kyle Anderson
 * @author Allison Clay
 * @author Alayna Richerson
 * @author John Weaver
 */
package application.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private ArrayList<Card> deck;

	/**
	 * CONSTRUCTOR: Makes a new Card ArrayList that represents a deck.
	 * The ArrayList will contain all 52 standard playing cards.
	 * Lastly, calls Shuffle to shuffle the deck.
	 * 
	 * @author Team rEach4help UTSA CS 3443
	 */
	public Deck() {
		this.deck = new ArrayList<Card>();
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				Card new1 = new Card(rank, suit);
				this.deck.add(new1);
			}
		}
		Collections.shuffle(this.deck);
	}

	/**
	 * METHOD:refill() Refills the deck with 52 standard cards.
	 * Calls Shuffle to shuffle the deck.
	 */
	public void refill() {
		for (int suit = 0; suit <= 3; suit++) {
			for (int rank = 1; rank <= 13; rank++) {
				Card new1 = new Card(rank, suit);
				this.deck.add(new1);
			}
		}
		Collections.shuffle(this.deck);
	}

	/**
	 * METHOD:deal() Creates the User's and Computers card hands by returning a
	 * sublist of the deck array.
	 * 
	 * @param n
	 *     This is the card number index.
	 * @param user
	 *     This is either the User or the Computer.
	 */
	public void deal(int n, User user) {
		/**
		 * toIndex of subList is exclusive.
		 * toIndex will be 1 less than n.
		 */
		List<Card> temp = this.deck.subList(0, n);
		user.addCardsHand(temp);
		remove(temp);
	}

	/**
	 * METHOD:remove() This removes specified cards from the deck.
	 * 
	 * @param temp
	 *     An arrayList of cards is passed in.
	 */
	public void remove(List<Card> temp) {
		this.deck.removeAll(temp);
	}

	/**
	 * METHOD: print() Prints to screen the String representation of a deck.
	 */
	public void print() {
		System.out.println("Deck:\nCards: " + String.valueOf(this.deck.size()));
		int i = 1;
		for (Card index : this.deck) {
			System.out.println(i + " - " + index);
			i++;
		}
	}

	@Override
	public String toString() {
		String s = "Deck:\n";
		int i = 1;
		for (Card index : this.deck) {
			s += i + " - " + index + "\n";
			i++;
		}
		return s;
	}

	/**
	 * METHOD:getDeck() Gets a deck of cards.
	 * 
	 * @return deck Returns the deck.
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}

	/**
	 * METHOD:setDeck() Sets a deck of cards.
	 * 
	 * @param deck
	 *     Sets the deck as an arrayList.
	 */
	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
}
