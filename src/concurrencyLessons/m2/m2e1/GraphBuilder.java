package concurrencyLessons.m2.m2e1;

import concurrencyLessons.m0.m0e2.GraphNode;
import concurrencyLessons.m0.m0e2.XOfield;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class GraphBuilder implements Callable<GraphNode> {

    private final ExecutorService executorService;

    private final XOfield.Figure nextFigure;

    private final XOfield currentField;

    private final int deepLevel;


    public GraphBuilder(ExecutorService executorService, XOfield.Figure nextFigure, XOfield currrentField, int deepLevel) {
        this.executorService = executorService;
        this.nextFigure = nextFigure;
        this.currentField = currrentField;
        this.deepLevel = deepLevel;
    }

    @Override
    public GraphNode call() throws Exception {
        final List<Future<GraphNode>> futures = new ArrayList<>();
        final Set<GraphNode> children = new CopyOnWriteArraySet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null) {
                    continue;
                }
                final XOfield newField = new XOfield(currentField);
                newField.setFigure(x, y, nextFigure);

                final GraphBuilder graphBuilder = new GraphBuilder(
                        executorService,
                        nextFigure,
                        currentField,
                        deepLevel + 1);
                if (isAsync()) {
                    final Future<GraphNode> future =
                                    executorService.submit(graphBuilder);
                    futures.add(future);
                } else {
                    children.add(graphBuilder.call());
                }
            }
            if (!futures.isEmpty()) {
                for (Future<GraphNode> future : futures) {
                    try {
                        children.add(future.get());
                    } catch (final InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }  return new GraphNode(currentField, children);
    }

    private boolean isAsync() {
            if (deepLevel > 3) {
                return false;
            } else {
                return true;
            }
        }

}
