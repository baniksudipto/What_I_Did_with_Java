package graphs;
/**
 * Created by Sudipta Banik on 11-07-2017.
 */
public abstract class Graph {
    protected int nodes = 0;

    Graph(){System.out.println("Graph constructor called ");}
    protected void setNodes(int nodes){
        this.nodes = nodes;
    }
}
