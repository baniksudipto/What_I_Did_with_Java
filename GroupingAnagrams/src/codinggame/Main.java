package codinggame;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<TreeMap<Character,Integer>,LinkedList<String>> mp = new HashMap<>();
        int n = sc.nextInt();
        TreeMap<Character,Integer> tree = null;
        for(int i=0;i<n;i++){
            String in = sc.next();
            tree = new TreeMap<>();
            for(char c:in.toCharArray()){
                tree.putIfAbsent(c,0);
                tree.put(c,tree.get(c) + 1);
            }
            mp.putIfAbsent(tree,new LinkedList<>());
            mp.get(tree).add(in);
        }

        System.out.println(mp);
    }
}
