package concurrencyLessons.m0e2;


import java.util.Set;

public class GraphNode {

    private final XOfield node;

    private final Set<GraphNode> children;

    public GraphNode(final XOfield node, final Set<GraphNode> children){
        this.node = node;
        this.children = children;
    }

    public XOfield getNode(){
        return node;
    }

    public Set<GraphNode> getChildren(){
        return children;
    }
}
