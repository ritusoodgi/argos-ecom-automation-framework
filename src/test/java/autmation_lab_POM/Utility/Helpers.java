package com.learning.mavenit.autmation_lab_POM.Utility;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Helpers {
    public void sleep(int time)
    {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int randomTest(int size) {
        Random random = new Random();
        return random.nextInt(size - 1);
    }
}
