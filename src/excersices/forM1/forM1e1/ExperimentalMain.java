package excersices.forM1.forM1e1;

public class ExperimentalMain {

    //  static long fibNumber = 15; // 610
    static long fibNumber = 25; // 75025

    public static void main(String... args)  {
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        long begin = System.currentTimeMillis();

        try {
            long result = ThreadHelper.fib(fibNumber);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }


        long end = System.currentTimeMillis();
        System.out.printf("Time spent: %d ms\n", end - begin);
    }
}