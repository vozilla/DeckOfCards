// Programmer: Ronin Sloan & Tuan Le
// Lab 4 -- Card Game
// Purpose: Create and run blackjack


public enum Suits {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    SPADES("Spades");

    final String string;

    //changes the value of string by using the
    // constant's parameter
    Suits(String face) {
    this.string = face;
    }
} // end enum Suits
