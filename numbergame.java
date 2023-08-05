//TASK-01 NUMBER GAME

import java.util.Scanner;
import java.util.Random;

public class numbergame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int Limit = 5;
        int score = 0;

        System.out.println("\n********************** ***** Welcome to Guess the Number Game! ***** **********************");

        do {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int guess;

            System.out.println("\nI have generated a number between " + minRange + " and " + maxRange + ".");

            while (attempts < Limit) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();
                attempts++;

                if (guess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    score += (Limit - attempts + 1);
                    break;
                } else if (guess < generatedNumber) {
                    System.out.println(" Too low :(\n Try again.....");
                } else {
                    System.out.println("Too high :(\n Try again.....");
                }
            }

            if (attempts == Limit) {
                System.out.println("\nYou've reached the maximum number of attempts. The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? \nEnter - y for YES || n for NO:");
            String playAgain = sc.next();

            if (playAgain.equalsIgnoreCase("n")) {
                break;
            }

        } while (true);

        System.out.println("\n********************** ***** Game Over ***** **********************\n\nYour total score is: " + score);
        sc.close();
    }
}
