/*
 * The Deck class represents a deck of cards.
 * The deck is made up of 52 playing cards.
 * There are methods for dealing cards, and removing cards from the deck.
 * @author Team rEach4help
 * UTSA CS 3443 - Team Project
 * Fall 2021
 */
package application.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private ArrayList<Card> deck;
	/*<<constructor>> will make a new Card ArrayList that represents
	 * a deck. The ArrayList will contain all 52 standard playing cards 
	 * Shuffle the deck last
	 */
	public Deck() {
		this.deck = new ArrayList<Card>();
		for(int suit = 0; suit <= 3; suit++) {
			for(int rank = 1; rank <= 13; rank++) {
				Card new1 = new Card(rank, suit);
				this.deck.add(new1);
			}
		}
		Collections.shuffle(this.deck);
	}
	/*refill() refills the deck with 52 standard  cards
	 *Shuffle the cards
	 */
	public void refill() {
		for(int suit = 0; suit <= 3; suit++) {
			for(int rank = 1; rank <= 13; rank++) {
				Card new1 = new Card(rank, suit);
				this.deck.add(new1);
			}
		}
		Collections.shuffle(this.deck);
	}
	/*deal() returns a sublist of the deck array
	 * @param int n
	 * @return: List<Card>
	 */
	public void deal(int n, User user){
		//toIndex of subList is exclusive. toIndex will be 1 less than n
		List<Card> temp = this.deck.subList(0, n);
		user.addCardsHand(temp);
		remove(temp);
		}
	/*remove() removes specified cards from the deck
	 * @param List<Card> list
	 */
	public void remove(List<Card> temp) {
		this.deck.removeAll(temp);
	}
	//print() prints to screen the String representation of a deck
	public void print() {
		System.out.println("Deck:\nCards: " + String.valueOf(this.deck.size()));
		int i = 1;
		for(Card index: this.deck) {
			System.out.println(i + " - " + index);
			i++;
		}
	}
	/*toString() returns a String representation of a deck
	 * @return: String
	 */
	public String toString() {
		String s = "Deck:\n";
		int i = 1;
		for(Card index: this.deck) {
			s += i + " - " + index + "\n";
			i++;
		}
		return s;
	}
	/*getDeck() gets a deck of cards
	 * @return ArrayList<Card>
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}
	/*setDeck() sets a deck of cards
	 * @param ArrayList<Card>
	 */
	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}
}