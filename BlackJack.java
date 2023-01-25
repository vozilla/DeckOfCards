// Programmer: Ronin Sloan & Tuan Le
// Lab 4 -- Card Game
// Purpose: Create and run blackjack

public class BlackJack {

    protected int dealerValue;
    protected int myValue;
    private String card;
    private int value;
    private DeckOfCards myDeckOfCards = new DeckOfCards();
    protected boolean dealersTurn;

    // CONSTRUCTOR
    public BlackJack() {
    this.dealersTurn = true;
    myDeckOfCards.shuffle();
    myDeckOfCards.shuffleStack();
    }


    // TAKES STRING OF CARD AND RETURNS ITS VALUE
    public int drawCard() {
        
        card = myDeckOfCards.dealCard();
        if (dealersTurn) {
            System.out.printf("%nDealer Draws: " + card);
            card = card.substring(0,4);
            value = toValue(card);
        }
        else {
            System.out.printf("%nYou Draw: " + card);
            card = card.substring(0,4);
            value = toValue(card);
        }
        return value;
    }


    // STARTS THE GAME BY DRAWING ONE CARD FOR THE DEALER
    // AND 2 CARDS FOR THE USER.
    public void startGame() {

        dealerValue += drawCard();
        dealersTurn = false;
        myValue += drawCard();
        myValue += drawCard();
        System.out.printf("%nYour Hand: " + myValue + 
        "%nDealer's Hand: " + dealerValue);
    }


    // ALLOWS USER TO DRAW A CARD
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
    }


    // ALLOWS USER TO STAND,
    // DEALER DRAWS CARD UNTIL THEY BUST, LOSE, OR HIT A BLACKJACK
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

    }


    //USES STRING TO RETURNS A SPECIFIC VALUE.
    public int toValue(String number) {
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
    }
}