import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final String RECORDS_FILE = "records.txt";
    private static int bestRecord = Integer.MAX_VALUE;

    public static void main(String[] args) {
        loadRecord();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        do {
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
                    System.out.printf("Поздравляю! Ты угадал за %d попыток!\n", attempts);
                    if (attempts < bestRecord) {
                        bestRecord = attempts;
                        saveRecord();
                        System.out.printf("Новый рекорд: %d попыток!\n", bestRecord);
                    } else {
                        System.out.printf("Текущий рекорд: %d попыток.\n", bestRecord);
                    }
                }
            } while (guess != target);

            System.out.print("Сыграем ещё? (да/нет): ");
            playAgain = scanner.next().toLowerCase();
        } while (playAgain.equals("да") || playAgain.equals("yes") || playAgain.equals("д"));

        System.out.println("Спасибо за игру!");
    }

    private static void loadRecord() {
        File file = new File(RECORDS_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                if (line != null && line.matches("\\d+")) {
                    bestRecord = Integer.parseInt(line.trim());
                }
            } catch (IOException e) {
                System.out.println("Не удалось загрузить рекорд.");
            }
        }
    }

    private static void saveRecord() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(RECORDS_FILE))) {
            writer.println(bestRecord);
        } catch (IOException e) {
            System.out.println("Не удалось сохранить рекорд.");
        }
    }
}