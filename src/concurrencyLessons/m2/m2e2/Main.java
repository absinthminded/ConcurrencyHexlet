package concurrencyLessons.m2.m2e2;



import concurrencyLessons.m0.m0e2.GraphNode;
import concurrencyLessons.m0.m0e2.XOfield;
import concurrencyLessons.m0.m0e3.GraphHelper;



import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Main {

    public static void main(String[] args) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final GraphBuilder gb = new GraphBuilder(XOfield.Figure.X, new XOfield(), 0);
        final ForkJoinTask<GraphNode> rootTask = gb.fork();
        forkJoinPool.submit(rootTask);
        System.out.println(GraphHelper.countNodes(rootTask.join()));

    }
}
