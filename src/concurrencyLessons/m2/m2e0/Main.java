package concurrencyLessons.m2.m2e0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws  Exception {

        final ExecutorService executorService = Executors.newWorkStealingPool(3);
        final SumRunnable sum = new SumRunnable(1,2);
        final Future<?> future = executorService.submit(sum);
        future.get();
        System.out.println(sum.getResult());
    }
}
