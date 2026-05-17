package org.example.utill;

public class SleepUtill {
    public static void sleep(int milliSecond){
        try{
            Thread.sleep(milliSecond);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
