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
	private ArrayList<Card> stack;
	//User constructor
	public User() {
		this.hand = new ArrayList<Card>();
		this.stack = new ArrayList<Card>();
	}
	/*addCardHand() adds a single card to a player's hand of cards
	 * @param: Card card
	 */
	public void addCardHand(Card card) {
		this.hand.add(card);
	}
	/*addCardsHand() adds cards to a player's hand of cards
	 * @param: List<Card> list
	 */
	public void addCardsHand(List<Card> list) {
		this.hand.addAll(list);
	}
	/*removeCardsHand() removes cards from a player's hand of cards
	 * @param: List<Card> list
	 */
	public void removeCardsHand(List<Card> list) {
		this.hand.removeAll(list);
	}
	/*removeCardHand() removes a single card from a player's hand of cards
	 * @param: Card card
	 */
	public void removeCardHand(Card card) {
		this.hand.remove(card);
	}
	
	/*addCardStack() adds a single card to a player's hand of cards
	 * @param: Card card
	 */
	public void addCardStack(Card card) {
		this.stack.add(card);
	}
	/*addCardsStack() adds cards to a player's hand of cards
	 * @param: List<Card> list
	 */
	public void addCardsStack(List<Card> list) {
		this.stack.addAll(list);
	}
	/*removeCardsStack() removes cards from a player's hand of cards
	 * @param: List<Card> list
	 */
	public void removeCardsStack(List<Card> list) {
		this.stack.removeAll(list);
	}
	/*removeCardStack() removes a single card from a player's hand of cards
	 * @param: Card card
	 */
	public void removeCardStack(Card card) {
		this.stack.remove(card);
	}
	/*clearHand() clears the user's hand to be empty
	 */
	public void clearHand() {
		this.hand.clear();
	}
	/*clearStack() clears the user's stack to be empty
	 */
	public void clearStack() {
		this.stack.clear();
	}
	public Card drawCard() {
		Card temp = hand.get(0);
		removeCardHand(temp);
		return temp;
	}
	/*numberHandCardsLeft() returns the number of cards left in the player's hand
	 * @return: int
	 */
	public int numberHandCards() {
		return this.hand.size();
	}
/*numberStackCardsLeft() returns the number of cards left in the player's stack
 * @return: int
 */
public int numberStackCards() {
	return this.stack.size();
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
	/**
	 * @return the stack
	 */
	public ArrayList<Card> getStack() {
		return stack;
	}
	/**
	 * @param stack the stack to set
	 */
	public void setStack(ArrayList<Card> stack) {
		this.stack = stack;
	}
	
}