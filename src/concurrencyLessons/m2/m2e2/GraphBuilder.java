package concurrencyLessons.m2.m2e2;

import concurrencyLessons.m0.m0e2.GraphNode;
import concurrencyLessons.m0.m0e2.XOfield;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class GraphBuilder extends RecursiveTask<GraphNode> {

    private final XOfield.Figure nextFigure;

    private final XOfield currentField;

    private final int deepLevel;


    public GraphBuilder(XOfield.Figure nextFigure, XOfield currentField, int deepLevel) {

        this.nextFigure = nextFigure;
        this.currentField = currentField;
        this.deepLevel = deepLevel;
    }

    @Override
    protected GraphNode compute() {
        final List<ForkJoinTask<GraphNode>> tasks = new ArrayList<>();
        final Set<GraphNode> children = new HashSet<>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (currentField.getFigure(x, y) != null) {
                    continue;
                }
                final XOfield newField = new XOfield(currentField);
                newField.setFigure(x, y, nextFigure);

                final GraphBuilder graphBuilder = new GraphBuilder(
                        nextFigure,
                        newField,
                        deepLevel + 1);
                if (isAsync()) {
                    tasks.add(graphBuilder.fork());
                } else {
                    children.add(graphBuilder.compute());
                }
            }
            if (!tasks.isEmpty()) {
                for (ForkJoinTask<GraphNode> task : tasks) {
                             children.add(task.join());
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
