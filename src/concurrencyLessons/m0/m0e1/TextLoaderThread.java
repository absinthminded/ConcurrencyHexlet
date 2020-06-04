package concurrencyLessons.m0.m0e1;

import concurrencyLessons.m0.m0e0.ITextLoader;

public class TextLoaderThread extends Thread {

    private final ITextLoader textLoader;

    public TextLoaderThread(final ITextLoader textLoader) {
        this.textLoader = textLoader;
    }

    @Override
    public void run() {
        System.out.println(textLoader.loadText());
    }
}
