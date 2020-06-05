package excersices.forM1.forM1e0;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ThreadHelper {

    public static int fib(final int numberToCalculate) throws Exception {
        final FibCalculator fibCalculator = new FibCalculator(numberToCalculate);
        fibCalculator.start();
        fibCalculator.join();
        return fibCalculator.getResult();
    }

    private static class FibCalculator extends Thread {
        // BEGIN (write your solution here)
        private int temp;
        private int result;

        public FibCalculator(final int numberToCalcucate) {
            this.temp = numberToCalcucate;
        }


        @Override
        public void run() {
            if (temp <= 1) {
                result = temp;
                return;
            }

            final FibCalculator left = new FibCalculator(temp -1);
            final FibCalculator right = new FibCalculator(temp - 2);

            left.start();
            right.start();

            try {
                left.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                right.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = left.getResult() + right.getResult();


        }

        public int getResult(){
            return result;
        }
        // END
        /*private int numberToCalcucate;

        public FibCalculator(final int numberToCalcucate) {
            this.numberToCalcucate = numberToCalcucate;
        }

        static int fib(int numberToCalcucate)
        {
            int result;
            if (numberToCalcucate <= 1)
                return numberToCalcucate;
            result = fib(numberToCalcucate-1) + fib(numberToCalcucate-2);
            return result;
        }

        public int getResult(){
            return fib(numberToCalcucate);
        }*/
    }
}
