/**
 * The User class represents a player in the game.
 * This class contains the player's current hand.
 * There are methods for adding and removing cards from a player's hand.
 * 
 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
 * @author Kyle Anderson
 * @author Allison Clay
 * @author Alayna Richerson
 * @author John Weaver
 */
package application.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private ArrayList<Card> hand;
	private ArrayList<Card> stack;

	/**
	 * CONSTRUCTOR: User Creates two arrayLists to represent the User's hand.
	 * 
	 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
	 */
	public User() {
		this.hand = new ArrayList<Card>();
		this.stack = new ArrayList<Card>();
	}

	/**
	 * METHOD:addCardHand() Adds a single card to a player's hand of cards.
	 * 
	 * @param card
	 *     This is the card to be passed to player's hand.
	 */
	public void addCardHand(Card card) {
		this.hand.add(card);
	}

	/**
	 * METHOD:addCardsHand() Adds cards to a player's hand of cards.
	 * 
	 * @param list
	 *     This is the arrayList of cards for the player's hand.
	 */
	public void addCardsHand(List<Card> list) {
		this.hand.addAll(list);
	}

	/**
	 * METHOD:removeCardsHand() Removes arrayList of cards from a player's hand
	 * of cards.
	 * 
	 * @param list
	 *     This is an arrayList of cards passed in.
	 */
	public void removeCardsHand(List<Card> list) {
		this.hand.removeAll(list);
	}

	/**
	 * METHOD:removeCardHand() Removes a single card from a player's hand of
	 * cards.
	 * 
	 * @param card
	 *     This is the card to remove from the player's arrayList.
	 */
	public void removeCardHand(Card card) {
		this.hand.remove(card);
	}

	/**
	 * METHOD:addCardStack() Adds a single card to a player's hand of cards.
	 * 
	 * @param card
	 *     Passes in the card to be added to the player's hand.
	 */
	public void addCardStack(Card card) {
		this.stack.add(card);
	}

	/**
	 * METHOD:addCardsStack() Adds cards to a player's hand of cards
	 * 
	 * @param list
	 *     The arrayList to be added to the player's hand.
	 */
	public void addCardsStack(List<Card> list) {
		this.stack.addAll(list);
	}

	/**
	 * METHOD:removeCardsStack() Removes cards from a player's hand of cards.
	 * 
	 * @param list
	 *     The arrayList of cards to be removed.
	 */
	public void removeCardsStack(List<Card> list) {
		this.stack.removeAll(list);
	}

	/**
	 * METHOD:removeCardStack() Removes a single card from a player's hand of
	 * cards.
	 * 
	 * @param card
	 *     The card to be removed.
	 */
	public void removeCardStack(Card card) {
		this.stack.remove(card);
	}

	/**
	 * METHOD:clearHand() Clears the user's hand to be empty.
	 */
	public void clearHand() {
		this.hand.clear();
	}

	/**
	 * METHOD:clearStack() Clears the user's stack to be empty.
	 */
	public void clearStack() {
		this.stack.clear();
	}

	/**
	 * METHOD: drawCard Removes the first card available in the arrayList.
	 * 
	 * @return temp This is the card being drawn.
	 */
	public Card drawCard() {
		Card temp = hand.get(0);
		removeCardHand(temp);
		return temp;
	}

	/**
	 * METHOD:numberHandCardsLeft() Returns the number of cards left in the
	 * player's hand.
	 * 
	 * @return integer Returns an integer showing the number of cards left in
	 *     the deck.
	 */
	public int numberHandCards() {
		return this.hand.size();
	}

	/**
	 * METHOD:numberStackCardsLeft() Returns the number of cards left in the
	 * player's stack.
	 * 
	 * @return integer Returns an integer showing the number of cards left in
	 *     the stack.
	 */
	public int numberStackCards() {
		return this.stack.size();
	}

	/**
	 * METHOD: print() Prints to screen the String representation of a hand of
	 * cards.
	 */
	public void print() {
		System.out.println("Hand:\nCards: " + String.valueOf(this.hand.size()));
		int i = 1;
		for (Card index : this.hand) {
			System.out.println(i + " - " + index);
			i++;
		}
	}

	@Override
	public String toString() {
		String s = "Hand:\n";
		int i = 1;
		for (Card index : this.hand) {
			s += i + " - " + index + "\n";
			i++;
		}
		return s;
	}

	/**
	 * METHOD:getHand() Returns a hand of cards.
	 * 
	 * @return hand This is an arrayList of cards.
	 */
	public ArrayList<Card> getHand() {
		return hand;
	}

	/**
	 * METHOD:setHand() Sets a hand of cards.
	 * 
	 * @param hand
	 *     This is an arrayList of cards.
	 */
	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}

	/**
	 * METHOD: getStack() This gets the player's stack of cards.
	 * 
	 * @return stack This is the player's stack of cards.
	 */
	public ArrayList<Card> getStack() {
		return stack;
	}

	/**
	 * METHOD: setStack This sets the cards for the stack.
	 * 
	 * @param stack
	 *     An arrayList of cards is passed in.
	 */
	public void setStack(ArrayList<Card> stack) {
		this.stack = stack;
	}

}
