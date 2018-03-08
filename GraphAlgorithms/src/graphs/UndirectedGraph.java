package graphs;

import java.util.*;

/**
 * Created by Sudipta Banik on 11-07-2017.
 */
public class UndirectedGraph extends DirectedGraph {
    @Override
    public void addEdge(Integer node1, int node2){
        adjList.putIfAbsent(node1,new TreeSet<>());
        adjList.putIfAbsent(node2,new TreeSet<>());
        adjList.get(node1).add(node2);
        adjList.get(node2).add(node1);

    }
}
