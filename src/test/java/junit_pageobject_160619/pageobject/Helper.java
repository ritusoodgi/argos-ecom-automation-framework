package junit_pageobject_160619.pageobject;

import java.util.Random;

public class Helper {

    public void sleep() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int randomNumberGenerator(int size) // to get the size of products
    {
        Random random = new Random();
        return random.nextInt(size - 1);
    }
}
