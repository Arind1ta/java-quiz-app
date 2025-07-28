import java.util.*;

class Question {
    String question;
    String[] options;
    char answer;

    Question(String question, String[] options, char answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    void displayQuestion() {
        System.out.println("\n" + question);
        char optionChar = 'A';
        for (String opt : options) {
            System.out.println(optionChar + ". " + opt);
            optionChar++;
        }
    }

    boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == Character.toUpperCase(answer);
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // List of questions
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("What is the capital of France?",
                new String[]{"Berlin", "London", "Paris", "Madrid"}, 'C'));
        quiz.add(new Question("Which data type is used to create a variable that should store text?",
                new String[]{"int", "char", "String", "float"}, 'C'));
        quiz.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"this", "super", "extends", "implements"}, 'C'));
        quiz.add(new Question("What is 5 + 3 * 2?",
                new String[]{"16", "11", "13", "10"}, 'B'));
        quiz.add(new Question("Which company developed Java?",
                new String[]{"Sun Microsystems", "Oracle", "IBM", "Microsoft"}, 'A'));

        int score = 0;

        System.out.println(" Welcome to the Java Quiz App!");
        

        for (Question q : quiz) {
            q.displayQuestion();
            System.out.print("Your answer (A/B/C/D): ");
            char userAnswer = sc.next().charAt(0);

            if (q.isCorrect(userAnswer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.answer);
            }
        }

        System.out.println("\n🎉 Quiz Over! Your score: " + score + "/" + quiz.size());
    }
}
