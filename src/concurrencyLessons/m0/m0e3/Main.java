package concurrencyLessons.m0.m0e3;

import concurrencyLessons.m0.m0e2.GraphNode;
import concurrencyLessons.m0.m0e2.XOfield;

public class Main {

    public static void main(String[] args){

        final GraphNode root = new GraphBuilder().build(XOfield.Figure.X, new XOfield());
        System.out.println(root.getNode());
        //GraphHelper.show(root, 0);
        System.out.println(GraphHelper.countNodes(root));
    }
}
