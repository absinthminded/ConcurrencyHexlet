package concurrencyLessons.m3;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final IntList intList = new IntList();
        final Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000 ; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    intList.add(i);
                }
            }
        };
        final Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000 ; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    intList.add(i);
                }
            }
        };
    t1.start();
    t2.start();
    t1.join();
    t2.join();
        System.out.printf("Size %d", intList.getSize());
    }
}
