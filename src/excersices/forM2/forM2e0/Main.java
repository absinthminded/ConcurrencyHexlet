package excersices.forM2.forM2e0;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String... args) {
        testArray(new Integer[0], 0);
        testArray(new Integer[]{1, 4, 10, 2}, 10);
        testArray(new Integer[]{1, 4, -10, 2}, 4);
        testArray(new Integer[]{1}, 1);
    }

    private static void testArray(final Integer[] inputArray, final int expectedResult) {
        final int actualResult = new MaxFinder(inputArray).call();
        if (actualResult != expectedResult) {
            throw new RuntimeException(
                    String.format(
                            "Actual max: %d, expected max: %d",
                            actualResult,
                            expectedResult));
        }
    }

    // BEGIN (write your solution here)
    private static class MaxFinder implements Callable<Integer> {

        private final Integer[] array;
        private int result;

        public MaxFinder(Integer[] array) {
            this.array = array;
        }

        @Override
        public Integer call() {
            if (array.length == 0) {
                System.out.println("0");
                return 0;
            }

            for (int i : array) {
                result = Math.max(i, result);
            }
            System.out.println(result);
            return result;
            /*return Collections.max(Arrays.asList(array));*/ //another way to count maxs
        }
    }
    // END
}
