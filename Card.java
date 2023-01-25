//card.java
//Card class represents a playing card

public class Card{
    private String face; //face of card ("ace, 11, etc.")
    private String suit; //suit of card ("hearts spades")

    //two-argument constructor initializes card's face and suit.
    public Card(String cardFace, String cardSuit){
        this.face = cardFace; //initializes face of card
        this.suit = cardSuit; //initializes suit of card
    }//end of constructor

    //return string representation of card
    public String toString(){
        return face + " of " + suit;
    }//end of toString method
}//end of class card