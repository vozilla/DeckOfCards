// Programmer: Ronin Sloan & Tuan Le
// Lab 4 -- Card Game
// Purpose: Create and run blackjack
    


import java.util.Scanner;
    
public class PlayGame extends CardGame {
    private int loop;
    private int roundLoop;
    private String response;
    CardGame blackJack = new CardGame();
    // Constructor
    public PlayGame(){
        this.loop = 0;
        this.roundLoop = 0;
    }
    // the main menu of the program
    public String mainMenu() {
        Scanner game = new Scanner(System.in);
        System.out.printf("Enter P to Play the Game%n");
        System.out.printf("or%n");
        System.out.printf("Enter E to Exit the Game%n");
        response = game.next();
        response = response.substring(0,1);
        return response;
    } // end of mainMenu method
    // starts a game of blackjack
    public void startGame() {
        while (loop != 1) {
            response = mainMenu();
            blackJack.myValue = 0;
            blackJack.dealerValue = 0;
            if (response.equalsIgnoreCase("P")) {
                startRound();
            }
            else if (response.equalsIgnoreCase("E")) {
                System.out.printf("%n%nYou Closed The Game%n%n");
                loop = 1;
            }
            else {
                System.out.printf("%n\tEnter a valid response%n%n");
            }
        }// end of while loop
    }// end of startGame
    // asks the user to hit or stand
    public String HitOrStand() {

        Scanner game = new Scanner(System.in);
        System.out.printf("%nEnter Either Hit or Stand%n");
        response = game.next();
        response = response.substring(0,1);
        return response;
    }     // end of hitOrStand method
    // starts a round of blackjack
    public void startRound() {
        blackJack.startGame();
        while (roundLoop != 1) {
        HitOrStand();
        if (response.equalsIgnoreCase("H")) {
            myValue = blackJack.hit();
            if (myValue > 21 || myValue == 21) {
                roundLoop = 1;
                blackJack.dealersTurn = true;
            }
        }
        else if (response.equalsIgnoreCase("S")) {
            dealerValue = blackJack.stand();
            roundLoop = 1;
        }
        else {
            System.out.printf("%n\tEnter a valid response%n%n");
        }
    }
        roundLoop = 0;
    }// end of startRound
}// end of class
