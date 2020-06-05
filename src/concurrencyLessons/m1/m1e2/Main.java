package concurrencyLessons.m1.m1e2;

import concurrencyLessons.m0.m0e2.GraphNode;
import concurrencyLessons.m0.m0e2.XOfield;
import concurrencyLessons.m0.m0e3.GraphHelper;
import concurrencyLessons.m1.m1e2.GraphBuilder;

public class Main {
    public static void main (String[] args) {
        final long before = System.currentTimeMillis();
        final GraphNode root = new GraphBuilder().build(XOfield.Figure.X, new XOfield(), 0);
        System.out.println(root.getNode());
        System.out.println(GraphHelper.countNodes(root));
        final long after = System.currentTimeMillis();
        System.out.printf("time delta %d", (after - before));
    }
}
