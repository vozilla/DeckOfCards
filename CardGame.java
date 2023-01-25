// Programmer: Ronin Sloan & Tuan Le
// Lab 4 -- Card Game
// Purpose: Create and run blackjack

public class CardGame {

    protected int dealerValue;
    protected int myValue;
    private String card;
    private int value;
    private DeckOfCards myDeckOfCards = new DeckOfCards();
    protected boolean dealersTurn;
    // Constructor
    public CardGame() {
        this.dealersTurn = true;
        myDeckOfCards.shuffle();
        myDeckOfCards.shuffleStack();
    } // end of CardGame Constructor
    // Method for starting a game of blackjack
    public void startGame() {

        dealerValue += drawCard();
        dealersTurn = false;
        myValue += drawCard();
        myValue += drawCard();
        System.out.printf("%nYour Hand: " + myValue + 
        "%nDealer's Hand: " + dealerValue);
    } // end of starGame method
    // Method for drawing a card
    public int drawCard() {
        
        card = myDeckOfCards.dealCard();
        if (dealersTurn) {
            System.out.printf("%nDealer Draws: " + card);
            card = card.substring(0,4);
            value = intValue(card);
        }
        else {
            System.out.printf("%nYou Draw: " + card);
            card = card.substring(0,4);
            value = intValue(card);
        }
        return value;
    } // end of drawCard method
    // Method for user to draw a card
    public int hit() {
        dealersTurn = false;
        myValue += drawCard();
        if (myValue == 21) {
            System.out.printf("%nMy Hand: " + 
            myValue + "%nDealer's Hand: " + dealerValue);
            System.out.printf("%n%n\tBlackjack! You win!%n%n");
            return myValue;
        }
        else if (myValue > 21) {
            System.out.printf("%nMy Hand: " + 
            myValue + "%nDealer's Hand: " + dealerValue);
            System.out.printf("%n%n\tBust. You lose.%n%n");
            return myValue;
        }
        else {
            System.out.printf("%nMy Hand: " + 
            myValue + "%nDealer's Hand: " + dealerValue);
        }
        dealersTurn = true;
        return myValue;
    } // end of hit method
    // Method for user to not draw a card
    public int stand() {
        
        dealersTurn = true;
        while (dealerValue < 21 && dealerValue < myValue ||
        dealerValue == myValue) { 
        dealerValue += drawCard();
        }
        if (dealerValue > 21) {
            System.out.printf("%nMy Hand: " + myValue +
             "%nDealer's Hand: " + dealerValue);
            System.out.printf("%n%n\tBust! You win.%n%n");
            myValue = 0;
            dealerValue = 0;
        }
        else if (dealerValue == 21) {
            System.out.printf("%nMy Hand: " + myValue +
             "%nDealer's Hand: " + dealerValue);
            System.out.printf("%n%n\tBlackjack. You lose.%n%n");
            myValue = 0;
            dealerValue = 0;
        }
        else {
            System.out.printf("%nMy Hand: " + myValue +
            "%nDealer's Hand: " + dealerValue);
            System.out.printf("%n%n\tHigher Value. You lose.%n%n");
            myValue = 0;
            dealerValue = 0;
        }
        return dealerValue;
    } // end of stand method
    // Method for taking a value out of a card
    public int intValue(String number) {
        number = number.substring(0,3);
        switch(number) {
            case "Ace":
                value = 1;
                break;
            case "Two":
                value = 2;
                break;
            case "Thr":
                value = 3;
                break;
            case "Fou":
                value = 4;
                break;
            case "Fiv":
                value = 5;
                break;
            case "Six":
                value = 6;
                break;
            case "Sev":
                value = 7;
                break;
            case "Eig":
                value = 8;
                break;
            case "Nin":
                value = 9;
                break;
            default:
                value = 10;
                break;
        }
        return value;
    } // end of intValue method
}