package graphs;

import java.util.*;

public class DirectedGraph extends Graph {
    Map< Integer,TreeSet<Integer>> adjList = new TreeMap<>();

    int getNodes(){return adjList.size();}
    public void addEdge(Integer source, int destination){
        adjList.putIfAbsent(source,new TreeSet<>());
        adjList.putIfAbsent(destination,new TreeSet<>());
        adjList.get(source).add(destination);
    }
    int getAdjListSize(){return adjList.size();}
    void print(){
        for(Integer list : adjList.keySet()){
            System.out.print(list + " -> ");
            for(Integer j : adjList.get(list)){
                System.out.print(j+" ");
            }
            System.out.print("\n");
        }
    }



    void BreadthFirstTraversal(int start){
        System.out.println();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(start);
        boolean[] visited = new boolean[getNodes()];
        for(int i=0;i<visited.length;i++)visited[i] = false;
        visited[start-1] = true;
        while (!queue.isEmpty()){
            int t = queue.poll();
            System.out.print(t + " ");
            for(Integer i : adjList.get(t)){
                if(!visited[i-1]){
                    queue.addLast(i);
                    visited[i-1] = true;
                }
            }
        }
        System.out.println();
    }



    void DepthFirstTraversal(int start){
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(start);
        boolean[] visited = new boolean[getNodes()];
        for(int i=0;i<visited.length;i++)visited[i] = false;
        visited[start-1] = true;
        while (!stack.isEmpty()){
            int top = stack.poll();
            System.out.print(top + " ");
            for(int i:adjList.get(top)){
                if(!visited[i-1]){
                    visited[i-1] = true;
                    stack.addFirst(i);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int s){
        boolean[] visited = new boolean[getNodes()+1];
        for(int i=0;i<getNodes();i++)visited[i] = false;
        dfsUtil(s,visited);
        System.out.println();
    }

    private void dfsUtil(int s, boolean[] visited) {
        if(visited[s]){
            return;
        }else {
            visited[s] = true;
            System.out.print(s+" ");
            for(int i:adjList.get(s)){
                if(!visited[i]){
                    dfsUtil(i,visited);
                }
            }
        }
    }
}
