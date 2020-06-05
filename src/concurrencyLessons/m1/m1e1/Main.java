package concurrencyLessons.m1.m1e1;

import concurrencyLessons.m0.m0e2.GraphNode;
import concurrencyLessons.m0.m0e2.XOfield;
import concurrencyLessons.m0.m0e3.GraphHelper;

public class Main {

    public static void main (String[] args) {
        final GraphNode root = new GraphBuilder().build(XOfield.Figure.X, new XOfield(), 0);
        System.out.println(root.getNode());
        System.out.println(GraphHelper.countNodes(root));
    }
}

