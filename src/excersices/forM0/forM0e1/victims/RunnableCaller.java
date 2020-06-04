package excersices.forM0.forM0e1.victims;

public class RunnableCaller {
    // BEGIN (write your solution here)

    public static SumRunnable getResultFromSumRunnable (final int[] array) throws InterruptedException {
        final  SumRunnable sumRunnable = new SumRunnable(array);
        final Thread thread = new Thread(sumRunnable);

        thread.start();

        thread.join();

        return sumRunnable;

    }
    // END
}
