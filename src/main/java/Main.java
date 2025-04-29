import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        Virus virus = new Virus();
        User user = new User();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Компьютер загадал число от 1 до 100. Попробуй угадать!");

        while (true) {
            String input = reader.readLine();

            // Проверяем, ввёл ли пользователь команду
            Command command = Command.fromString(input);

            switch (command) {
                case RESULT:
                    // Вывод статистики
                    System.out.println("Текущее количество попыток: " + user.getTries());
                    System.out.println("Лучший результат: " + (user.getBestTries() == Integer.MAX_VALUE ? "Нет" : user.getBestTries()));
                    continue;

                case EXIT:
                    System.out.println("Выход из игры. Пока!");
                    return;

                case UNKNOWN:
                    // Не команда — значит, возможно, число
                    break;
            }

            // Пытаемся интерпретировать ввод как число
            try {
                int guess = Integer.parseInt(input);
                user.incrementTries();

                if (guess < virus.getSecretNumber()) {
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                } else if (guess > virus.getSecretNumber()) {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                } else {
                    System.out.println("Поздравляю! Ты угадал!");
                    System.out.println("Количество попыток: " + user.getTries());

                    user.updateBestTries();
                    System.out.println("Лучший результат: " + user.getBestTries());

                    // Начинаем новую игру
                    virus.generateNewNumber();
                    user.resetTries();
                    System.out.println("\nНачинаем новую игру! Угадай новое число!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число или команду (RESULT / EXIT).");
            }
        }
    }
}