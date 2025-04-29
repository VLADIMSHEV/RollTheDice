

//Eum для команд пользователя

enum Command {
    RESULT,
    EXIT,
    UNKNOWN;

    // Метод для преобразования строки в команду
    public static Command fromString(String input) {
        try {
            return Command.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return UNKNOWN; // Если строка не является командой
        }
    }
}

