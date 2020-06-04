package excersices.forM0.forM0e1.victims;

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
