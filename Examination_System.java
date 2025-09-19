import java.util.Scanner;

public class Examination_System {
    static String username = "sanjana";
    static String password = "1234";
    static Scanner sc = new Scanner(System.in);

    static String[] questions = {
        "Q1. Which of the following is a valid data type in Java?\nA. number\nB. int\nC. real\nD. doubleint",
        "Q2. What is the size of int in Java?\nA. 4 bytes\nB. 8 bytes\nC. 2 bytes\nD. Depends on system",
        "Q3. Which method is the entry point of a Java program?\nA. start()\nB. main()\nC. run()\nD. static()",
        "Q4. Java is a:\nA. Platform-independent language\nB. Platform-dependent language\nC. Machine language\nD. None",
        "Q5. Which of the following is NOT a Java keyword?\nA. static\nB. try\nC. Integer\nD. new"
    };

    static String[] correctAnswers = {"B", "A", "B", "A", "C"};
    static String[] userAnswers = new String[5];

    public static void main(String[] args) {
        if (login()) {
            System.out.println("\nLogin Successful!");
            startExam();
        } else {
            System.out.println("\nLogin Failed. Exiting...");
        }
    }

    static boolean login() {
        System.out.println("====== LOGIN ======");
        System.out.print("Enter Username: ");
        String user = sc.nextLine();
        System.out.print("Enter Password: ");
        String pass = sc.nextLine();
        return user.equals(username) && pass.equals(password);
    }

    static void startExam() {
        int score = 0;
        System.out.println("\n====== JAVA MCQ TEST ======\n");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Answer: ");
            userAnswers[i] = sc.nextLine();

            if (userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                score++;
            }
        }

        showResult(score);
        reviewAnswers();
    }

    static void showResult(int score) {
        System.out.println("\n====== RESULT ======");
        System.out.println("Total Questions: 5");
        System.out.println("Correct Answers: " + score);
        System.out.println("Wrong Answers: " + (5 - score));
        System.out.println("Your Score: " + (score * 20) + "%");

        if (score >= 3) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }

        System.out.println("Thank you for taking the exam!");
    }

    static void reviewAnswers() {
        System.out.println("\n====== ANSWER REVIEW ======");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Your Answer   : " + userAnswers[i].toUpperCase());
            System.out.println("Correct Answer: " + correctAnswers[i]);
            if (userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                System.out.println("Result        :  Correct\n");
            } else {
                System.out.println("Result        :  Wrong\n");
            }
        }
    }
}

