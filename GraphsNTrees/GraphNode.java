import java.util.ArrayList;

public class GraphNode{
    public String name;
    public ArrayList<GraphNode> children;
    public boolean marked = false;
    public GraphNode(String name) {
        this.name = name;
        children=new ArrayList<>();
    }
    public void addNode(GraphNode node){
        children.add(node);
    }
    @Override
    public String toString(){
        return name;
    }

}