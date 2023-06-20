

public class RouteNodes {
    public static void main(String[] args) {
        Graph graph = createGraph();
        GraphNode start = graph.getNode("1");
        GraphNode end = graph.getNode("7");
       System.out.println(verifyPath(start, end));
    }

    public static boolean verifyPath(GraphNode start,GraphNode end){
        MyQueue<GraphNode> mq = new MyQueue<GraphNode>();
        mq.add(start);
        while(!mq.isEmpty()){
            GraphNode nextNode=mq.remove();
            if(nextNode.equals(end))return true;
            if (!nextNode.marked) {
                nextNode.marked=true;
                for (GraphNode node : nextNode.children) {
                    mq.add(node);
                }
            }
            
        }
        return false;
    }



    public static Graph createGraph(){
        Graph graph = new Graph();
        GraphNode one = graph.addNode("1");
        GraphNode two = graph.addNode("2");
        GraphNode three = graph.addNode("3");
        GraphNode four = graph.addNode("4");
        GraphNode five = graph.addNode("5");
        GraphNode six = graph.addNode("6");
        GraphNode seven = graph.addNode("7");
        GraphNode eight = graph.addNode("8");
        GraphNode nine = graph.addNode("9");
        one.addNode(two);
        one.addNode(three);
        one.addNode(six);
        two.addNode(three);
        two.addNode(four);
        three.addNode(two);
        three.addNode(four);
        three.addNode(five);
        four.addNode(five);
        four.addNode(eight);
        four.addNode(seven);
        five.addNode(one);
        five.addNode(four);
        five.addNode(six);
        five.addNode(nine);
        six.addNode(nine);
        six.addNode(seven);
        seven.addNode(eight);
        seven.addNode(five);
        eight.addNode(nine);
        nine.addNode(seven);
        return graph;
    }
}
