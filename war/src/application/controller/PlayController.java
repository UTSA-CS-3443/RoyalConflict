/**
 * The PlayController class controls the page that plays the game.
 * This class controls a button that leads back to the menu screen.
 * 
 * @author Team rEach4help UTSA CS 3443 - Team Project Fall 2021
 * @author Kyle Anderson
 * @author Allison Clay
 * @author Alayna Richerson
 * @author John Weaver
 */
package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.Card;
import application.model.Deck;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayController implements EventHandler<Event>, Initializable {

	@FXML
	Button menuButton, play_again_button;

	@FXML
	Label play_label, player_label, computer_label,
			player_deck_cards_left,
			computer_cards_left, info_label,
			player_stack_cards_label, computer_stack_cards_label, deck_label,
			stack_label, winning_card_label,
			war_pool_label, titleLabel;
	@FXML
	ImageView player_deck, computer_deck, player_card, computer_card,
			begin_deck, player_stack, computer_stack,
			computer_war_slot, player_war_slot;

	/** This Creates the deck and players. */
	Deck deck1 = new Deck();
	User player = new User();
	User computer = new User();
	ArrayList<Card> warPool = new ArrayList<Card>();
	boolean playerStackWasZero = true;
	boolean computerStackWasZero = true;
	boolean warOver = true;
	int warCardsLeft = 4;

	/**
	 * initialize() Sets the credits label with the team members names.
	 * 
	 * @param location
	 *     ResourceBundle that was given to the FXMLLoader.
	 * @param resources
	 *     URL location of the FXML file given to the FXMLLoader.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/** Auto-generated method stub. */
	}

	/**
	 * handle() A placeholder for the javaFX EventHandler interface.
	 * 
	 * @param event
	 *     One of the fxml buttons was clicked.
	 */
	@Override
	public void handle(Event event) {
		/** Auto-generated method stub. */
	}

	/**
	 * METHOD:play_again Sets values to null, except beginning deck, so the game
	 * can begin again.
	 * 
	 * @param event
	 *     The play_again button was clicked.
	 */
	public void play_again(Event event) {
		begin_deck.setDisable(false);
		Image deck = new Image("File:images/deck.jpg");
		begin_deck.setImage(deck);
		play_label.setText("Click deck to play");

		/** Make other images and labels null. */
		war_pool_label.setText(null);
		winning_card_label.setText(null);
		stack_label.setText(null);
		deck_label.setText(null);
		computer_stack_cards_label.setText(null);
		player_stack_cards_label.setText(null);
		info_label.setText(null);
		info_label.setVisible(false);
		computer_cards_left.setText(null);
		player_deck_cards_left.setText(null);
		computer_label.setText(null);
		player_label.setText(null);
		player_war_slot.setImage(null);
		computer_war_slot.setImage(null);
		computer_stack.setImage(null);
		player_stack.setImage(null);
		computer_card.setImage(null);
		player_card.setImage(null);
		computer_deck.setImage(null);
		player_deck.setImage(null);

		/** Hide & disable the play again button. */
		play_again_button.setDisable(true);

		play_again_button.setVisible(false);

		/** Reset cards, hands, stacks, and important values. */
		deck1.refill();

		player.clearHand();
		player.clearStack();

		computer.clearHand();
		computer.clearStack();

		warPool.clear();
		playerStackWasZero = true;
		computerStackWasZero = true;
		warOver = true;
		warCardsLeft = 4;

	}

	/**
	 * METHOD:start_game This begins game play. Sets up players and decks, and
	 * begins a new game of war.
	 * 
	 * @param event
	 *     The deck button was clicked.
	 */
	public void start_game(Event event) {
		/** Allow the player deck to be pressed again. */
		player_deck.setDisable(false);

		/** Deal half of the deck to both players. */
		deck1.deal(26, player);
		deck1.deal(26, computer);

		/** Set labels and images to play game. */
		play_label.setText("");
		begin_deck.setImage(null);
		Image deck = new Image("File:images/deck.jpg");
		computer_deck.setImage(deck);
		player_deck.setImage(deck);
		player_label.setText("Player");
		computer_label.setText("Computer");
		computer_cards_left.setText("Cards: " + computer.numberHandCards());
		player_deck_cards_left.setText("Cards: " + player.numberHandCards());
		computer_stack_cards_label
				.setText("Cards: " + computer.numberStackCards());
		player_stack_cards_label.setText("Cards: " + player.numberStackCards());
		info_label.setVisible(true);
		info_label.setText("Draw a card");
		info_label.setStyle("-fx-background-color: yellow");
		begin_deck.setDisable(true);
		deck_label.setText("Deck");
		stack_label.setText("Stack");
	}

	/**
	 * METHOD:draw During game play, the player will click their deck to
	 * initiate a cycle of card play. Controls the main flow of the game, each
	 * draw the player or the computer wins the cards played.
	 * 
	 * @param event
	 *     The player clicked their deck to draw a card.
	 */
	public void draw(Event event) {
		if (warOver == false) {
			if (warCardsLeft == 1) {

				/** Pick the final war card and compare them. */
				Card player_drawn_card = player.drawCard();
				Image card = new Image("File:images/playing_cards/"
						+ player_drawn_card.getCardImageName());
				player_card.setImage(card);
				player_deck_cards_left
						.setText("Cards: " + player.numberHandCards());

				Card computer_drawn_card = computer.drawCard();
				card = new Image("File:images/playing_cards/"
						+ computer_drawn_card.getCardImageName());
				computer_card.setImage(card);
				computer_cards_left
						.setText("Cards left: " + computer.numberHandCards());

				/** Update the number of cards left in the decks. */
				player_deck_cards_left
						.setText("Cards: " + player.numberHandCards());
				computer_cards_left
						.setText("Cards: " + computer.numberHandCards());

				/**
				 * Add the last card to the war pool of cards for the winner to
				 * get.
				 */
				warPool.add(player_drawn_card);
				warPool.add(computer_drawn_card);

				/** Update war_pool_label. */
				war_pool_label
						.setText("War pool: " + warPool.size() + " cards");

				/** Check if someone ran out of cards. */
				if (player.numberHandCards() + player.numberStackCards() == 0) {
					info_label
							.setText("Player ran out of cards! Computer wins!");
					/** Turn deck button off, game is over. */
					player_deck.setDisable(true);

					/** Show & enable the play again button. */
					play_again_button.setDisable(false);
					play_again_button.setVisible(true);
				}
				else
					if (computer.numberHandCards()
							+ computer.numberStackCards() == 0) {
						info_label.setText(
								"Computer ran out of cards! Player wins!");
						/** Turn deck button off, game is over. */
						player_deck.setDisable(true);

						/** Show & enable the play again button. */
						play_again_button.setDisable(false);
						play_again_button.setVisible(true);
					}

				/**
				 * Check if player's hand ran out of cards, but player still has
				 * cards in stack.
				 */
				if (player.numberHandCards() == 0
						&& player.numberStackCards() != 0) {
					playerStackWasZero = true;

					/**
					 * Add stack cards to hand, and set the stack to 0 cards.
					 */
					player.addCardsHand(player.getStack());
					player.removeCardsStack(player.getStack());
					player_stack.setImage(null);
					player_deck_cards_left
							.setText("Cards: " + player.numberHandCards());
					player_stack_cards_label
							.setText("Cards: " + player.numberStackCards());
				}
				if (computer.numberHandCards() == 0
						&& computer.numberStackCards() != 0) {
					computerStackWasZero = true;

					/**
					 * Add stack cards to hand, and set the stack to 0 cards.
					 */
					computer.addCardsHand(computer.getStack());
					computer.removeCardsStack(computer.getStack());
					computer_stack.setImage(null);
					computer_cards_left
							.setText("Cards: " + computer.numberHandCards());
					computer_stack_cards_label
							.setText("Cards: " + computer.numberStackCards());
				}

				/** Cases for comparing the card values. */
				if (player_drawn_card.getRank() == computer_drawn_card
						.getRank()) {

					/** Final cards matched, the war continues. */
					warOver = false;
					warCardsLeft = 4;
					winning_card_label.setText("The cards are equal!");
					/** Update the info label. */
					info_label.setText("Tie! The war continues!");
				}
				else
					if (player_drawn_card.compare(computer_drawn_card) == 1) {
						player.addCardsStack(warPool);

						/** Player wins the war pool. */
						if (playerStackWasZero == true) {
							Image deck = new Image("File:images/deck.jpg");
							player_stack.setImage(deck);
							playerStackWasZero = false;
						}

						/** Update war_pool_label. */
						war_pool_label.setText(
								"Player won war pool: " + warPool.size()
										+ " cards");

						/** Empty the war pool deck, someone has won them. */
						warPool.clear();

						player_war_slot.setImage(null);
						computer_war_slot.setImage(null);
						warOver = true;

						/**
						 * Update the player's stack label to show they won
						 * cards.
						 */
						player_stack_cards_label
								.setText("Cards: " + player.numberStackCards());
						winning_card_label.setText(
								player_drawn_card.toString()
										+ " is victorious!");

						/** Update the info label. */
						info_label.setText(
								"Player has won the war!\nDraw a card");
					}
					else
						if (computer_drawn_card
								.compare(player_drawn_card) == 1) {
							computer.addCardsStack(warPool);

							/** Computer wins the war pool. */
							if (computerStackWasZero == true) {
								Image deck = new Image("File:images/deck.jpg");
								computer_stack.setImage(deck);
								computerStackWasZero = false;
							}

							/** Update war_pool_label. */
							war_pool_label.setText(
									"Computer won war pool: " + warPool.size()
											+ " cards");
							/** Empty the war pool deck,someone has won them. */
							warPool.clear();
							player_war_slot.setImage(null);
							computer_war_slot.setImage(null);
							warOver = true;

							/**
							 * Update the computer's stack label to show they
							 * won cards.
							 */
							computer_stack_cards_label
									.setText("Cards: "
											+ computer.numberStackCards());
							winning_card_label.setText(
									computer_drawn_card.toString()
											+ " is victorious!");

							/** Update the info label. */
							info_label.setText(
									"Computer has won the war!\nDraw a card");

							/** Check if someone ran out of cards. */
							if (player.numberHandCards()
									+ player.numberStackCards() == 0) {
								info_label.setText(
										"Player ran out of cards! Computer wins!");

								/** Turn deck button off, game is over. */
								player_deck.setDisable(true);

								/** Show and enable the play again button. */
								play_again_button.setDisable(false);
								play_again_button.setVisible(true);
							}
							else
								if (computer.numberHandCards()
										+ computer.numberStackCards() == 0) {
									info_label.setText(
											"Computer ran out of cards! Player wins!");
									/** Turn deck button off, game is over. */
									player_deck.setDisable(true);

									/** Show & enable the play again button. */
									play_again_button.setDisable(false);
									play_again_button.setVisible(true);
								}

							/**
							 * Check if someone ran out of cards in hand, but
							 * has cards in stack.
							 */
							if (player.numberHandCards() == 0
									&& player.numberStackCards() != 0) {
								playerStackWasZero = true;

								/**
								 * Add stack cards to hand & reset stack to 0.
								 */
								player.addCardsHand(player.getStack());
								player.removeCardsStack(player.getStack());
								player_stack.setImage(null);
								player_deck_cards_left
										.setText("Cards: "
												+ player.numberHandCards());
								player_stack_cards_label
										.setText("Cards: "
												+ player.numberStackCards());
							}
							if (computer.numberHandCards() == 0
									&& computer.numberStackCards() != 0) {
								computerStackWasZero = true;
								/**
								 * Add stack cards to hand, and set the stack to
								 * 0 cards.
								 */
								computer.addCardsHand(computer.getStack());
								computer.removeCardsStack(computer.getStack());
								computer_stack.setImage(null);
								computer_cards_left
										.setText("Cards: "
												+ computer.numberHandCards());
								computer_stack_cards_label
										.setText("Cards: "
												+ computer.numberStackCards());
							}
						}
			}
			else
				if (warCardsLeft > 1) {
					Card player_drawn_card = player.drawCard();
					Image card = new Image("File:images/playing_cards/"
							+ player_drawn_card.getCardImageName());
					player_war_slot.setImage(card);
					player_deck_cards_left
							.setText("Cards: " + player.numberHandCards());
					player_stack_cards_label
							.setText("Cards: " + player.numberStackCards());

					Card computer_drawn_card = computer.drawCard();
					card = new Image("File:images/playing_cards/"
							+ computer_drawn_card.getCardImageName());
					computer_war_slot.setImage(card);
					computer_cards_left
							.setText("Cards left: "
									+ computer.numberHandCards());
					computer_stack_cards_label
							.setText("Cards: " + computer.numberStackCards());

					/**
					 * Update the deck labels to show the updated number of
					 * cards left.
					 */
					player_deck_cards_left
							.setText("Cards: " + player.numberHandCards());
					computer_cards_left
							.setText("Cards: " + computer.numberHandCards());

					/**
					 * Picking cards, set the winning_card_label to null (no one
					 * won yet).
					 */
					winning_card_label.setText(null);

					/**
					 * Add the cards to the war pool to save for the player
					 * winning the war.
					 */
					warPool.add(player_drawn_card);
					warPool.add(computer_drawn_card);

					/** Update war_pool_label. */
					war_pool_label
							.setText("War pool: " + warPool.size() + " cards");

					warCardsLeft--;
					/** Update the info_label for how many cards left. */
					info_label.setText("Draw " + warCardsLeft + " more cards");

					/** Check if someone ran out of cards. */
					if (player.numberHandCards()
							+ player.numberStackCards() == 0) {
						info_label.setText(
								"Player ran out of cards! Computer wins!");

						/** Turn deck button off, game is over. */
						player_deck.setDisable(true);

						/** Show and enable the play again button. */
						play_again_button.setDisable(false);
						play_again_button.setVisible(true);
					}
					else
						if (computer.numberHandCards()
								+ computer.numberStackCards() == 0) {
							info_label.setText(
									"Computer ran out of cards! Player wins!");

							/** Turn deck button off, game is over. */
							player_deck.setDisable(true);

							/** Show and enable the play again button. */
							play_again_button.setDisable(false);
							play_again_button.setVisible(true);
						}

					/**
					 * Check if someone ran out of cards in hand, but has cards
					 * in stack.
					 */
					if (player.numberHandCards() == 0
							&& player.numberStackCards() != 0) {
						playerStackWasZero = true;
						/**
						 * Add stack cards to hand, and set the stack to 0
						 * cards.
						 */
						player.addCardsHand(player.getStack());
						player.removeCardsStack(player.getStack());
						player_stack.setImage(null);
						player_deck_cards_left
								.setText("Cards: " + player.numberHandCards());
						player_stack_cards_label
								.setText("Cards: " + player.numberStackCards());
					}
					if (computer.numberHandCards() == 0
							&& computer.numberStackCards() != 0) {
						computerStackWasZero = true;
						/**
						 * Add stack cards to hand, and set the stack to 0
						 * cards.
						 */
						computer.addCardsHand(computer.getStack());
						computer.removeCardsStack(computer.getStack());
						computer_stack.setImage(null);
						computer_cards_left
								.setText(
										"Cards: " + computer.numberHandCards());
						computer_stack_cards_label
								.setText("Cards: "
										+ computer.numberStackCards());
					}
				}

		}
		else
			if (warOver == true) {
				/** Update war_pool_label */
				war_pool_label.setText(null);

				/** Update info_label (draw a card, there is no war). */
				info_label.setText("Draw a card");
				Card player_drawn_card = player.drawCard();
				Image card = new Image("File:images/playing_cards/"
						+ player_drawn_card.getCardImageName());
				player_card.setImage(card);
				player_deck_cards_left
						.setText("Cards: " + player.numberHandCards());
				player_stack_cards_label
						.setText("Cards: " + player.numberStackCards());

				Card computer_drawn_card = computer.drawCard();
				card = new Image("File:images/playing_cards/"
						+ computer_drawn_card.getCardImageName());
				computer_card.setImage(card);
				computer_cards_left
						.setText("Cards left: " + computer.numberHandCards());
				computer_stack_cards_label
						.setText("Cards: " + computer.numberStackCards());

				/** Update the deck labels to show the number of cards left. */
				player_deck_cards_left
						.setText("Cards: " + player.numberHandCards());
				computer_cards_left
						.setText("Cards: " + computer.numberHandCards());

				/** Check if someone ran out of cards. */
				if (player.numberHandCards() + player.numberStackCards() == 0) {
					info_label
							.setText("Player ran out of cards! Computer wins!");
					/** Turn deck button off, game is over. */
					player_deck.setDisable(true);
					/** Show and enable the play again button. */
					play_again_button.setDisable(false);

					play_again_button.setVisible(true);
				}
				else
					if (computer.numberHandCards()
							+ computer.numberStackCards() == 0) {
						info_label.setText(
								"Computer ran out of cards! Player wins!");
						/** Turn deck button off, game is over. */
						player_deck.setDisable(true);
						/** Show and enable the play again button. */
						play_again_button.setDisable(false);
						play_again_button.setVisible(true);
					}

				/**
				 * Check if someone ran out of cards in hand, but has cards in
				 * stack.
				 */
				if (player.numberHandCards() == 0
						&& player.numberStackCards() != 0) {
					playerStackWasZero = true;
					/**
					 * Add stack cards to hand, and set the stack to 0 cards.
					 */
					player.addCardsHand(player.getStack());
					player.removeCardsStack(player.getStack());
					player_stack.setImage(null);
					player_deck_cards_left
							.setText("Cards: " + player.numberHandCards());
					player_stack_cards_label
							.setText("Cards: " + player.numberStackCards());
				}
				if (computer.numberHandCards() == 0
						&& computer.numberStackCards() != 0) {
					computerStackWasZero = true;
					/**
					 * Add stack cards to hand, and set the stack to 0 cards.
					 */
					computer.addCardsHand(computer.getStack());
					computer.removeCardsStack(computer.getStack());
					computer_stack.setImage(null);
					computer_cards_left
							.setText("Cards: " + computer.numberHandCards());
					computer_stack_cards_label
							.setText("Cards: " + computer.numberStackCards());
				}

				/** Cases for comparing the card values. */
				if (player_drawn_card.getRank() == computer_drawn_card
						.getRank()) {
					/** Set values, now have the player pick 4 more cards. */
					warOver = false;
					warCardsLeft = 4;
					/** Update the info_label to show we are going to war. */
					info_label.setText("War! Each player draws 4 cards!");
					/**
					 * Put the cards into the war pool to keep track of them.
					 */
					warPool.add(player_drawn_card);
					warPool.add(computer_drawn_card);

					/** Update war_pool_label. */
					war_pool_label
							.setText("War pool: " + warPool.size() + " cards");

					/** Update the winning_card_label to tell what card won. */
					winning_card_label.setText("The cards are equal ranks!");

				}
				else
					if (player_drawn_card.compare(computer_drawn_card) == 1) {
						/**
						 * Player card wins: Both cards go to the player's
						 * stack.
						 */
						player.addCardStack(player_drawn_card);
						player.addCardStack(computer_drawn_card);

						/** Check if the stack was zero. */
						if (playerStackWasZero == true) {
							Image deck = new Image("File:images/deck.jpg");
							player_stack.setImage(deck);
							playerStackWasZero = false;
						}

						/**
						 * Update the winning_card_label to tell what card won.
						 */
						winning_card_label.setText(
								player_drawn_card.toString()
										+ " is victorious!");

						/**
						 * Update the stack label to show updated number of
						 * player's stack cards.
						 */
						player_stack_cards_label
								.setText("Cards: " + player.numberStackCards());
						if (playerStackWasZero == true) {
							Image stack = new Image("File:images/deck.jpg");
							player_stack.setImage(stack);
							playerStackWasZero = false;
						}

					}
					else {
						/**
						 * Computer card wins: Both cards go to the computer's
						 * stack.
						 */
						computer.addCardStack(player_drawn_card);
						computer.addCardStack(computer_drawn_card);

						/** Check if the stack was zero. */
						if (computerStackWasZero == true) {
							Image deck = new Image("File:images/deck.jpg");
							computer_stack.setImage(deck);
							computerStackWasZero = false;
						}

						/**
						 * Update the winning_card_label to tell what card won.
						 */
						winning_card_label.setText(
								computer_drawn_card.toString()
										+ " is victorious!");

						/**
						 * Update the stack label to show updated number of
						 * computer's stack cards.
						 */
						computer_stack_cards_label
								.setText("Cards: "
										+ computer.numberStackCards());
						if (computerStackWasZero == true) {
							Image stack = new Image("File:images/deck.jpg");
							computer_stack.setImage(stack);
							computerStackWasZero = false;
						}

						/** Check if someone ran out of cards. */
						if (player.numberHandCards()
								+ player.numberStackCards() == 0) {
							info_label.setText(
									"Player ran out of cards! Computer wins!");
							/** Turn deck button off, game is over. */
							player_deck.setDisable(true);
							/** Show and enable the play again button. */
							play_again_button.setDisable(false);
							play_again_button.setVisible(true);
						}
						else
							if (computer.numberHandCards()
									+ computer.numberStackCards() == 0) {
								info_label.setText(
										"Computer ran out of cards! Player wins!");
								/** Turn deck button off, game is over. */
								player_deck.setDisable(true);
								/** Show and enable the play again button. */
								play_again_button.setDisable(false);
								play_again_button.setVisible(true);
							}

						/**
						 * Check if someone ran out of cards in hand, but has
						 * cards in stack.
						 */
						if (player.numberHandCards() == 0
								&& player.numberStackCards() != 0) {
							playerStackWasZero = true;
							/**
							 * Add stack cards to hand, and set the stack to 0
							 * cards.
							 */
							player.addCardsHand(player.getStack());
							player.removeCardsStack(player.getStack());
							player_stack.setImage(null);
							player_deck_cards_left
									.setText("Cards: "
											+ player.numberHandCards());
							player_stack_cards_label
									.setText("Cards: "
											+ player.numberStackCards());
						}
						if (computer.numberHandCards() == 0
								&& computer.numberStackCards() != 0) {
							computerStackWasZero = true;
							/**
							 * Add stack cards to hand, and set the stack to 0
							 * cards.
							 */
							computer.addCardsHand(computer.getStack());
							computer.removeCardsStack(computer.getStack());
							computer_stack.setImage(null);
							computerStackWasZero = true;
							computer_cards_left
									.setText("Cards: "
											+ computer.numberHandCards());
							computer_stack_cards_label
									.setText("Cards: "
											+ computer.numberStackCards());
						}

					}
			}
	}

	/**
	 * METHOD: menu Launches the menu (front page) scene. Allows the user to
	 * press the menu button to return to the main page of the application.
	 * 
	 * @param event
	 *     The menu button was clicked.
	 */
	public void menu(ActionEvent event) {
		try {
			Parent root = FXMLLoader
					.load(getClass().getResource("../view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.setTitle("Menu");
			Main.stage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
