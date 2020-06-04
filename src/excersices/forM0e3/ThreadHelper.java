package excersices.forM0e3;

public class ThreadHelper {
    public static void startAndJoinThread(final Thread t) throws Exception {
        // BEGIN (write your solution here)
        t.start();
        t.join();
        // END
    }
}
