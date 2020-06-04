package concurrencyLessons.m0.m0e0;

public class MainWithThreads {

    public static void main(String[] args) {
        final ITextLoader fileTextLoader = new MockLoader("Text from file");
        final ITextLoader webTextLoader = new MockLoader("textFromWeb");
        final long before = System.currentTimeMillis();
        final Thread fileTextLoaderThread = new Thread() {
            @Override
            public void run() {
                System.out.println(fileTextLoader.loadText());
            }
        };
        fileTextLoaderThread.start();

        final  Thread webTextLoaderThread = new Thread() {
            @Override
            public void run() {
                System.out.println(webTextLoader.loadText());
            }
        };
        webTextLoaderThread.start();
     /*   fileTextLoaderThread.join(3);
        webTextLoaderThread.join(0);*/
        final long after = System.currentTimeMillis();
        System.out.printf("time delta: %d", (after - before) / 1000);
    }
}
