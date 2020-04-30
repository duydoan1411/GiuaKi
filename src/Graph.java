import java.util.HashSet;
import java.util.Set;

public class Graph {
    private Set<NodeGraph> nodes = new HashSet<>();

    public void addNode(NodeGraph nodeA) {
        nodes.add(nodeA);
    }

    public Set<NodeGraph> getNodes() {
        return nodes;
    }

    public void setNodes(Set<NodeGraph> nodes) {
        this.nodes = nodes;
    }
}
