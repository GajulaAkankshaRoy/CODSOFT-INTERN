import java.util.Scanner;
import java.util.Random; 

public class NumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 75;
        int maxAttempts = 5;
        int totalAttempts = 0;
        int rounds = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Numbering Game!");

        while (playAgain) {
            rounds++;
            System.out.println("\nRound " + rounds + ":");
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I've picked a number between " + lowerBound + " and " + upperBound + ". Guess what it is.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scan.nextInt();
                attempts++;

                if (guess < targetNumber) {
                    System.out.println("very low! Try again.");
                } else if (guess > targetNumber) {
                    System.out.println("very high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number " + targetNumber + " correctly in " + attempts + " attempts!");
                    totalAttempts += attempts;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scan.next().toLowerCase();
            playAgain = playAgainResponse.startsWith("y");
        }

        System.out.println("\nThank you for playing! Your average number of attempts per round was: " + (double) totalAttempts / rounds);
    }
}
