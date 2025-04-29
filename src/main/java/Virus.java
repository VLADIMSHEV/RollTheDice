import java.util.Random;

public class Virus {
    public static int virus() {

        Random random = new Random();
        int min = 1;
        int max = 100;

        return  random.nextInt(max) + min;
    }


}
