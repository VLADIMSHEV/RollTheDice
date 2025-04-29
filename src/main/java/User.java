

// Класс игрока
class User {
    private int tries;
    private int bestTries = Integer.MAX_VALUE;

    public void incrementTries() {
        tries++;
    }

    public void resetTries() {
        tries = 0;
    }

    public void updateBestTries() {
        if (tries < bestTries) {
            bestTries = tries;
        }
    }

    public int getTries() {
        return tries;
    }

    public int getBestTries() {
        return bestTries;
    }
}