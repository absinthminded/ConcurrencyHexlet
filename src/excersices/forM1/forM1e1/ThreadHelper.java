package excersices.forM1.forM1e1;

import java.lang.reflect.Field;
import java.util.concurrent.*;

public class ThreadHelper {

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    // BEGIN (write your solution here) Какой сервис вы создадите и присвоите ссылке выше?

    // END

    public static long fib(final long numberToCalculate) throws Exception {
        // BEGIN (write your solution here)
        {
            if (numberToCalculate <= 1)
                return numberToCalculate;
            return fib(numberToCalculate-1) + fib(numberToCalculate-2);
        }
        // END
    }

    private static class FibCalculator implements Runnable {

        private final long currentNum;

        private long result = 0;

        public FibCalculator(final long numberToCalculate) {
            this.currentNum = numberToCalculate;
        }

        @Override
        public void run() {
            if (currentNum == 1 || currentNum == 2) {
                result = 1;
                return;
            }
            if (currentNum <= 0) {
                result = 0;
                return;
            }
            final FibCalculator left = new FibCalculator(currentNum - 1);
            final FibCalculator right = new FibCalculator(currentNum - 2);
            final Future leftF =  EXECUTOR_SERVICE.submit(left);
            final Future rightF =  EXECUTOR_SERVICE.submit(right);
            try {
                leftF.get();
                rightF.get();
            } catch (final InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            result = left.getResult() + right.getResult();
        }

        public long getResult() {
            return result;
        }
    }
}
