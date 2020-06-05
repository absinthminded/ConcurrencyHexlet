package concurrencyLessons.m1.m1e2;

import concurrencyLessons.m0.m0e2.GraphNode;
import concurrencyLessons.m0.m0e2.XOfield;

import java.util.*;
import java.util.concurrent.*;

public class GraphBuilder {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newWorkStealingPool(3);

    public GraphNode build (final XOfield.Figure currentFigure,
                            final XOfield currentField,
                            final int deepLevel) {
       final boolean async;
       if (deepLevel >  3) {
           async = false;
       }else {
           async = true;
       }
        final List<Future> futures = new ArrayList<>();
        final XOfield.Figure nextFigure
                = currentFigure == XOfield.Figure.O ? XOfield.Figure.X : XOfield.Figure.O;
        final Set<GraphNode> children = new CopyOnWriteArraySet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null){
                    continue;
                }
                final XOfield newField = new XOfield(currentField);
                newField.setFigure(x, y, nextFigure);
                if (async){
                final Future<?> future = EXECUTOR_SERVICE.submit(new Runnable() {
                    @Override
                    public void run() {
                        children.add(build(nextFigure, newField, deepLevel + 1));
                    }
                });
                futures.add(future);
            } else {
                    children.add(build(nextFigure, newField, deepLevel + 1));
                }
            }
        }
        if (async) {
            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (final InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return new GraphNode(currentField, children);
    }
}
