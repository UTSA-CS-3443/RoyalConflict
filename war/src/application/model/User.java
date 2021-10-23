/*
 * The User class represents a player in the game.
 * This class contains the player's current hand.
 * There are methods for adding and removing cards from a player's hand.
 * @author Team rEach4help
 * UTSA CS 3443 - Team Project
 * Fall 2021
 */
package application.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private ArrayList<Card> hand;
	//User constructor
	public User() {
		this.hand = new ArrayList<Card>();
	}
	/*addCard() adds a single card to a player's hand of cards
	 * @param: Card card
	 */
	public void addCard(Card card) {
		this.hand.add(card);
	}
	/*addCards() adds cards to a player's hand of cards
	 * @param: List<Card> list
	 */
	public void addCards(List<Card> list) {
		this.hand.addAll(list);
	}
	/*removeCards() removes cards from a player's hand of cards
	 * @param: List<Card> list
	 */
	public void removeCards(List<Card> list) {
		this.hand.removeAll(list);
	}
	/*removeCard() removes a single card from a player's hand of cards
	 * @param: Card card
	 */
	public void removeCard(Card card) {
		this.hand.remove(card);
	}
	//print() prints to screen the String representation of a hand of cards
	public void print() {
		System.out.println("Hand:\nCards: " + String.valueOf(this.hand.size()));
		int i = 1;
		for(Card index: this.hand) {
			System.out.println(i + " - " + index);
			i++;
		}
	}
	/*toString() returns a String representation of a hand of cards
	 * @return: String
	 */
	public String toString() {
		String s = "Hand:\n";
		int i = 1;
		for(Card index: this.hand) {
			s += i + " - " + index + "\n";
			i++;
		}
		return s;
	}
	/*getHand() returns a hand of cards
	 * @return: ArrayList<Card>
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}
	/*setHand() sets a hand of cards
	 * @param ArrayList<Card>
	 */
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
}