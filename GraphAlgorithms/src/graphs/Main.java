package graphs;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static int input(String s){
        System.out.print(s);
        return sc.nextInt();
    }
    public static void main(String[] args) {

        UndirectedGraph gr = new UndirectedGraph();

        int q = input("Enter No of edges to add ");
        for(int i=0;i<q;i++){
            gr.addEdge(sc.nextInt(),sc.nextInt());
        }

        System.out.print(gr.getAdjListSize() + "\n");
        int ch = input("Test Runs : ");
        for (int i = 0; i < ch ; i++) {
            int k = input("Enter Starting Point ");
            gr.BreadthFirstTraversal(k);
            gr.dfs(k);
        }
    }
}
