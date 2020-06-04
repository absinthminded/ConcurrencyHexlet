package concurrencyLessons.m0.m0e0;

public class MockLoader  implements ITextLoader{

    private final String textToLoad;

    public MockLoader(final String textToLoad) {
        this.textToLoad = textToLoad;
    }

    @Override
    public String loadText() {
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } return textToLoad;
    }
}
