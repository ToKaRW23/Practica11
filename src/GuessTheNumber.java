import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int target = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;

        System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");

        do {
            System.out.print("Твой вариант: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < target) {
                System.out.println("Больше!");
            } else if (guess > target) {
                System.out.println("Меньше!");
            } else {
                System.out.printf("Угадал за %d попыток!\n", attempts);
            }
        } while (guess != target);

        System.out.println("Игра окончена.");
    }
}