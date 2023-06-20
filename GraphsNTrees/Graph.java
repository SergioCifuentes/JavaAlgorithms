import java.util.ArrayList;

public class Graph {
    public ArrayList<GraphNode> nodes= new ArrayList<>();

    public GraphNode addNode(String name){
        GraphNode newNode = new GraphNode(name);
        nodes.add(newNode);
        return newNode;
    }

    public void addEdge(GraphNode start, GraphNode end){
        start.children.add(end);
    }
    public void unmarkNodes(){
        for (GraphNode node : nodes) {
            node.marked=false;
        }
    }
    public GraphNode getNode(String name){
        for (GraphNode node : nodes) {
           
            if (node.name.equals(name))return node; 
        }
        return null;
    }
}
