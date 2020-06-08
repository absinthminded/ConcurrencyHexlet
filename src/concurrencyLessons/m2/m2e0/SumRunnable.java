package concurrencyLessons.m2.m2e0;

public class SumRunnable implements Runnable {

    private final int a;
    private final int b;
    private int result;

    public SumRunnable(final int a, final int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {

        result = a + b;
    }

    public int getResult(){
        return result;
    }
}
