// James Underwood
// CSC 160 Computer Science I
// Nov 7, 2022
// Semester Final Project - Dice Game: 30 or Bust!


import java.util.Scanner;

public class Main {
    static int output;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello, what is the name of the first player? ");
        String player1name = input.next();
        System.out.println("Hello, what is the name of the second player? ");
        String player2name = input.next();

        //Set player names using Player.class
        Player player1 = new Player();
        player1.setName(player1name);
        Player player2= new Player();
        player2.setName(player2name);

        System.out.println( "Welcome players " + player1.getName() + " and " + player2.getName() + "!");
        System.out.println( "The goal of this game is to accumulate a player score of exactly 30. The first player " +
                "to score exactly 30 is the Winner!");
        System.out.println("Would you like more detailed instructions on how to play? Y or N");
        String instructions = input.next();
        if(instructions.equalsIgnoreCase("Y")){
            System.out.println("You will roll a pair of dice, then you must choose the score of one of the dice or " +
                    "the total of the two dice. This value is added to your player score. If your score goes over " +
                    "30, your score is reset to zero. Player turn changes after each roll of the dice. You win when " +
                    "you accumulate a score of exactly 30.\n");
        }
        System.out.println("Here we go!");
        int total; //total of dice value
        while (player1.getScore() != 30 && player2.getScore() != 30) {
            System.out.println("Player " + player1.getName() + ", it is your turn!");
            System.out.println("Your score: " + player1.getScore());
            roll();
            total = player1.getScore() + output;
            player1.setScore(total);

            if(player1.getScore()==30) {
                System.out.println("*** "+player1.getName()+", you win ! ***");
            }
            else if (player1.getScore()>30) {
                System.out.println("*** "+player1.getName()+", you lose and go back to 0! ***");
                player1.setScore(0);
            } else {
                System.out.println(player1.getName()+", your new score is: "+player1.getScore());
            }
            System.out.println("----------------------------------------");

            System.out.println("Player " + player2.getName() + ", it is your turn!");
            System.out.println("Your score: " + player2.getScore());
            roll();
            total = player2.getScore() + output;
            player2.setScore(total);
            if(player2.getScore()==30) {
                System.out.println("*** "+player2.getName()+", you win ! ***");
            }
            else if (player2.getScore()>30) {
                System.out.println("*** "+player2.getName()+", you lose and go back to 0! ***");
                player2.setScore(0);
            } else {
                System.out.println(player2.getName()+", your new score is: "+player2.getScore());
            }
            System.out.println("----------------------------------------");
        }
    }

    static void roll(){
        int score = 0, min=1, max=6;
        int dice1, dice2;

        dice1 = min + (int)(Math.random() * ((max - min) + 1));
        dice2 = min + (int)(Math.random() * ((max - min) + 1));
        System.out.println("You rolled "+dice1+" and "+dice2+" for a total of "+(dice1+dice2)+"!\n");

        boolean validChoice = false;
        while (!validChoice) {
            System.out.println("Do you wish to (1) Keep die 1, (2) Keep die 2, (3) Keep the total? (Respond with 1 or 2 or 3): ");
            Scanner input = new Scanner(System.in);
            int keep = input.nextInt();
            if (keep == 1) {
                validChoice = true;
                output = dice1;
            } else if (keep == 2) {
                validChoice = true;
                output = dice2;
            } else if (keep == 3) {
                validChoice = true;
                output = dice1 + dice2;
            } else {
                System.out.println("You've entered an invalid choice");
            }
        }
    }
}