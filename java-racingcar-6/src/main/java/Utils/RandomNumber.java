package Utils;

import java.util.Random;

public class RandomNumber {
    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 10;
    Random random = new Random();

    public int generationNumber(){
        return random.nextInt(START_NUMBER, LAST_NUMBER);
    }
}
