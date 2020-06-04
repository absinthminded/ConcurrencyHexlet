package concurrencyLessons.m1.m1e0;


import concurrencyLessons.m0.m0e2.GraphNode;
import concurrencyLessons.m0.m0e2.XOfield;

import java.util.*;

public class GraphBuilder {

    public GraphNode build (final XOfield.Figure currentFigure,
                            final XOfield currentField,
                            final int deepLevel) {
        if (deepLevel > 3) return new GraphNode(currentField, Collections.emptySet());
        final List<Thread> threads = new ArrayList<>();
        final XOfield.Figure nextFigure
                = currentFigure == XOfield.Figure.O ? XOfield.Figure.X : XOfield.Figure.O;
        final Set<GraphNode> children = new HashSet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null){
                    continue;
                }
                final XOfield newField = new XOfield(currentField);
                newField.setFigure(x, y, nextFigure);
                final Thread threadThatAddsChildren = new Thread() {
                    @Override
                    public void run() {
                        children.add(build(nextFigure, newField, deepLevel + 1));
                    }
                };
                threadThatAddsChildren.start();
                threads.add(threadThatAddsChildren);
            }
        }
        for (Thread th : threads) {
            try {
                th.join();
            } catch (final InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return new GraphNode(currentField, children);
    }
}
