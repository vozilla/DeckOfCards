// Programmer: Ronin Sloan & Tuan Le
// Lab 4 -- Card Game
// Purpose: Create and run blackjack


import java.security.SecureRandom;
import java.util.EmptyStackException;
import java.util.Stack;

// CREATES THE DECK OF CARDS, SHUFFLES THE DECK, & USES STACK TO DRAW
// INDIVIDUAL CARDS
public class DeckOfCards {
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52;
    private Card[] deck = new Card[NUMBER_OF_CARDS];
    Stack<String> shuffledStack = new Stack<String>();
    private String card;

    public DeckOfCards() {
        String[] faces = {"Ace", "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
        
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for (int count = 0; count < deck.length; count++) {
        deck[count] = new Card(faces[count % 13], suits[count/13]);

        }   
    } // end of Constructor

    
    //SHUFFLES DECK
    public void shuffle() {
        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            //Swap cards
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    } // end of shuffle


    // USES THE STRING OF THE DECK STRING ARRAY, AND
    // ADDS THAT STRING TO THE STACK.
    public void shuffleStack() {
        for (int first = 0; first < deck.length; first ++) {
            card = deck[first].toString();
            shuffledStack.push(card);
        }
    }


    // DEALS 1 CARD BY REMOVING THE TOP CARD ON THE STACK
    // IF STACK SIZE IS 1, ADD MORE CARDS TO THE STACK
    public String dealCard() throws EmptyStackException { 
        if (shuffledStack.size() != 1) {
            return shuffledStack.pop();
        }
        else {
            System.out.println("Shuffling Cards...\n");
            shuffle();
            shuffleStack();
            return shuffledStack.pop();
        }
    }
}// end of class
