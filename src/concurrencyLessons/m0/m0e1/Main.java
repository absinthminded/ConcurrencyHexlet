package concurrencyLessons.m0.m0e1;

import concurrencyLessons.m0.m0e0.MockLoader;

public class Main {
    public static void main(String[] args) {

        final long before = System.currentTimeMillis();
        /*final Thread loader = new TextLoaderThread(new MockLoader("thread1"));
        loader.start();// async via thread*/
        final Runnable runnableLoader = new TextLoaderRunnable(new MockLoader("thread2"));
       final Thread thread = new Thread(runnableLoader);// put runnableThread into Thread to async it
       thread.start();// run thread with runnable;
        final long after = System.currentTimeMillis();
        System.out.printf("time delta: %d\n", (after - before) / 1000);

    }
}
