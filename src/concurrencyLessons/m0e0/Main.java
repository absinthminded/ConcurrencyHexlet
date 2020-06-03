package concurrencyLessons.m0e0;

public class Main {

    public static void main(String[] args) {
        final ITextLoader fileTextLoader = new MockLoader("Text from file");
        final ITextLoader webTextLoader = new MockLoader("Text from Web");
        final long before = System.currentTimeMillis();
        System.out.println(fileTextLoader.loadText());
        System.out.println(webTextLoader.loadText());
        final long after = System.currentTimeMillis();
        System.out.printf("time delta: %d\n", (after - before) / 1000);

    }
}
