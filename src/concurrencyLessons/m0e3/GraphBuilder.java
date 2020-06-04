package concurrencyLessons.m0e3;

import concurrencyLessons.m0e2.GraphNode;
import concurrencyLessons.m0e2.XOfield;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class GraphBuilder {

    public GraphNode build(final XOfield.Figure currentFigure, final XOfield currentField) {
        final XOfield.Figure nextFigure = currentFigure == XOfield.Figure.O ? XOfield.Figure.X : XOfield.Figure.O;
        final Set<GraphNode> children = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (currentField.getFigure(i, j) != null) {
                    continue;
                }
                final XOfield newField = new XOfield(currentField);
                newField.setFigure(i, j, nextFigure);
                children.add(build(nextFigure, newField));
            }
        }
        return new GraphNode(currentField, children);
    }
}
