package excersices.forM0.forM0e2;


public class MaxRunnable implements Runnable {

    final int[] target;

    private int result;

    public MaxRunnable(final int[] target){
        this.target = target;
    }

    public int getResult(){
        return result;
    }

    @Override
    public void run() {
       for (int i : target){
           result = Math.max(i, result);
           //result = IntStream.of(target).max().getAsInt();// the same via Stream
       }
            }




}
