package excersices.forM0e1.victims;

public class SumRunnable implements Runnable {

    // BEGIN (write your solution here)
    private int[] array;

    public SumRunnable(int[] array) {
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
        System.out.println("henlo");
    }



    // END
}
