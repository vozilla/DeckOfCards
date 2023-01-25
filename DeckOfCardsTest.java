// Programmer: Ronin Sloan & Tuan Le
// Lab 4 -- Card Game
// Purpose: Create and run blackjack

public class DeckOfCardsTest {
    public static void main (String[] args) {
        DeckOfCards myDeckOfCards = new DeckOfCards();
        myDeckOfCards.shuffle();
        myDeckOfCards.shuffleStack();
        PlayGame playGame = new PlayGame();
    
        playGame.startGame();
    
    } // End of Main Method
} // end of class