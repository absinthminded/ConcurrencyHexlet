package excersices.forM0e2.victims;

import java.util.stream.*;

public class SumThread extends Thread{

    private int[] array;

    public SumThread(int[] array){
        this.array = array;
    }

    public int getResult() {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    @Override
    public void run() {
        System.out.println("hello");
    }
}
