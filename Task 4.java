import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz {
    private String[] questions;
    private String[][] options;
    private int[] answers;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;

    public Quiz(String[] questions, String[][] options, int[] answers) {
        this.questions = questions;
        this.options = options;
        this.answers = answers;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.timer = new Timer();
    }

    public void startQuiz() {
        System.out.println("Welcome to the Quiz!");
        askQuestion();
    }

    private void askQuestion() {
        if (currentQuestionIndex < questions.length) {
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + questions[currentQuestionIndex]);
            for (int i = 0; i < options[currentQuestionIndex].length; i++) {
                System.out.println((char) ('A' + i) + ". " + options[currentQuestionIndex][i]);
            }

            Scanner scan = new Scanner(System.in);
            System.out.print("Enter your answer (A/B/C/D): ");
            char userAnswer = scan.next().toUpperCase().charAt(0);

            if (userAnswer == (char) ('A' + answers[currentQuestionIndex])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }

            currentQuestionIndex++;

            // Set timer for next question (10 seconds)
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    askQuestion();
                }
            }, 5000);
        } else {
            endQuiz();
        }
    }

    private void endQuiz() {
        System.out.println("Quiz ended!");
        System.out.println("Your score: " + score + "/" + questions.length);
        timer.cancel();
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        String[] questions = {
            "What is the capital of Australia?",
            "What is the green planet in our solar system?",
            "Who is the father of Indian Missile Technology?"
        };

        String[][] options = {
            {"London", "canberra", "Berlin", "Madrid"},
            {"Mars", "Uranus", "Earth", "Saturn"},
            {"Dr Homi Bhadha", "Dr Chidambaram", "Dr U.R.Rao", "Dr A.P.J.Abdul Kalam"}
        };

        int[] answers = {1, 1, 3}; // Indices of correct answers

        Quiz quiz = new Quiz(questions, options, answers);
        quiz.startQuiz();
    }
}

