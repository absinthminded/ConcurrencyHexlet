package concurrencyLessons.m0e1;

import concurrencyLessons.m0e0.ITextLoader;

public class TextLoaderRunnable implements Runnable {

    private final ITextLoader textLoader;

    public TextLoaderRunnable(final ITextLoader textLoader){
        this.textLoader = textLoader;
    }

    @Override
    public void run() {
        System.out.println(textLoader.loadText());
    }
}
