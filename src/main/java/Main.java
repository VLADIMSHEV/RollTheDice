import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;







public static void input() throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
        String input;


        while (true) {
            input = reader.readLine();

            if (input.equalsIgnoreCase("RESULT")) {
                System.out.println("Количество попыток: " + NumbersOfTries);
                System.out.println("Количество попыток в лучшей игре: " + NumberOfBestTries);
                continue;
            }

            try {
                int inputtedNumberFromUser = Integer.parseInt(input);
                comparison(inputtedNumberFromUser);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число или 'RESULT'");
            }
        }
    }
}

public static void comparison(int userNumber) {
    NumbersOfTries++;

    if (userNumber < generatedNumberFromVirus) {
        System.out.println("Я сам в шоке, но загаданное число больше, брат");
    } else if (userNumber > generatedNumberFromVirus) {
        System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
    } else {
        System.out.println("Красава! Ты угадал число!");
        System.out.println("Количество попыток: " + NumbersOfTries);

        if (NumbersOfTries < NumberOfBestTries) {
            NumberOfBestTries = NumbersOfTries;
        }

        System.out.println("Количество попыток в лучшей игре: " + NumberOfBestTries);

        // Начать новую игру
        generatedNumberFromVirus = PersonalComputer.virus();
        System.out.println("\nНачинаем новую игру! Угадай новое число!");
        NumbersOfTries = 0;
    }
}
