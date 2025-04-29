

// Класс вируса с загаданным числом
class Virus {
    private int secretNumber;

    public Virus() {
        generateNewNumber();
    }

    public void generateNewNumber() {
        this.secretNumber = (int) (Math.random() * 100) + 1; // от 1 до 100 включительно
    }

    public int getSecretNumber() {
        return secretNumber;
    }
}