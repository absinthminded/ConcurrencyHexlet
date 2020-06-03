package excersices.forM0e2.victims;

public class ThreadCaller {
    // BEGIN (write your solution here)
    public static SumThread getResultFromSumThread(final int[] array) throws InterruptedException {
        final SumThread sumThread = new SumThread(array);

        sumThread.start();

        sumThread.join();

        return sumThread;

    }
    // END
}
