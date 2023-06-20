import java.util.Arrays;

public class BuildOrder {
    public static void main(String[] args) {
        Graph graph =createGraph();
        System.out.println(Arrays.toString(getBuildOrder(graph)));
    }

    public static GraphNode[] getBuildOrder(Graph graph){
        GraphNode[] order = new GraphNode[graph.nodes.size()];
        int index=0;
        boolean changes=true;
        while (changes && !graph.nodes.isEmpty()) {
            changes =false;
            for (int i = 0; i < graph.nodes.size(); i++) {
                GraphNode node=graph.nodes.get(i);
                removeChildren(node, order);
                if (node.children.isEmpty()) {
                    order[index]=node;
                    index++; 
                    changes =true;
                    graph.nodes.remove(node);
                    
                }
            }
            if(!changes) return null;
            
        }
        

        return order;
    }
    public static void removeChildren(GraphNode node,GraphNode[] order){
        for (GraphNode removeNode : order) {
            node.children.remove(removeNode);
        }
    }

    public static Graph createGraph(){
        Graph graph = new Graph();
        GraphNode a = graph.addNode("A");
        GraphNode b = graph.addNode("B");
        GraphNode c = graph.addNode("C");
        GraphNode d = graph.addNode("D");
        GraphNode e = graph.addNode("E");
        GraphNode f = graph.addNode("F");
        graph.addEdge(d, a);
        graph.addEdge(b, f);
        graph.addEdge(d, b);
        graph.addEdge(c, d);
        graph.addEdge(a, f);
        
        return graph;
    }
}
