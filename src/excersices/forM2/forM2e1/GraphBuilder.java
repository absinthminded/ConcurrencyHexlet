package excersices.forM2.forM2e1;


import concurrencyLessons.m0.m0e2.GraphNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class GraphBuilder implements Callable<Set<GoField>> {

    private final ExecutorService executorService;

    private final Figure nextFigure;

    private final GoField currentField;

    private final int deepLevel;

    public GraphBuilder(
            final ExecutorService executorService,
            final Figure currentFigure,
            final GoField currentField,
            final int deepLevel) {
        this.executorService = executorService;
        this.currentField = currentField;
        this.nextFigure = currentFigure == Figure.WHITE ? Figure.BLACK : Figure.WHITE;
        this.deepLevel = deepLevel;
    }

    @Override
    public Set<GoField> call() throws Exception {
        // BEGIN (write your solution here) #1
        if (isCurrentFieldFinal()) {
            /*HashSet<GoField> tempSet = new HashSet<>();
            tempSet.add(currentField);
            return tempSet;*/
            return new HashSet<GoField>(){{add(currentField);}};
        }

        final List<Future<Set<GoField>>> futures = new ArrayList<>();
        final Set<GoField> result = new HashSet<>();

        final GoField newField = new GoField();

        for (int x = 0; x < GoField.FIELD_SIZE; x++) {
            for (int y = 0; y < GoField.FIELD_SIZE; y++) {
                if (currentField.figures[x][y] != null) {
                    continue;
                }

                newField.setFigure(x, y, nextFigure);

                final GraphBuilder graphBuilder = new GraphBuilder(
                                                    executorService,
                                                    nextFigure,
                                                    new GoField(currentField, nextFigure, x, y),
                                                    deepLevel + 1);
                if (isAsync()) {
                    final Future<Set<GoField>> future =
                                            executorService.submit(graphBuilder);
                    futures.add(future);
                } else {
                    result.addAll(graphBuilder.call());
                }

                if (!futures.isEmpty()) {
                    for (Future<Set<GoField>> future : futures) {
                        try {
                            result.addAll(future.get());
                        } catch (final InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        } return result;
        // END #4
    }

    private boolean isAsync() {
        return deepLevel <= 2;
    }

    private boolean isCurrentFieldFinal() {
        for (Figure[] line : currentField.figures) {
            for (Figure f : line) {
                if (f == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
