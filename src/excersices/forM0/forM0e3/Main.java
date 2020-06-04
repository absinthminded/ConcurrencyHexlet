package excersices.forM0.forM0e3;

public class Main {

    public static void main(String... args) throws Exception {
        final ThreadTester tt = new ThreadTester();
        ThreadHelper.startAndJoinThread(tt);
        if (!tt.isStartUsed()) {
            throw new RuntimeException("Looks like start() method was not called on the Thread");
        }
        if (tt.isAlive()) {
            throw new RuntimeException("Looks like join() method was not called on the Thread");
        }
    }

    private static class ThreadTester extends Thread {

        private boolean startUsed;

        @Override
        public void start() {
            super.start();
            startUsed = true;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3_000);
            } catch (final Exception e) {}
        }

        public boolean isStartUsed() {
            return startUsed;
        }
    }
}
