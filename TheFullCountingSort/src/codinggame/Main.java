import java.util.LinkedList;
import java.io.*;
import java.util.TreeMap;

public class Main {

    static class pair{
        public String s;
        public boolean first;
        pair(String s,boolean f){
            this.s = s;
            first = f;
        }
    }
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader (new InputStreamReader(System.in));
        TreeMap<Integer,LinkedList<pair>> mp= new TreeMap<>();
        int n= 0;
        try {
            n = Integer.parseInt(sc.readLine());
        } catch (IOException e) {
           n++;
        }
        int k;String s;
        for(int i=0;i<n;i++){
            String[] in = new String[0];
            try {
                in = sc.readLine().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            k = Integer.parseInt(in[0]);
            mp.putIfAbsent(k,new LinkedList<>());
            if(i<n/2){
                mp.get(k).add(new pair(in[1],true));
            }else{
                mp.get(k).add(new pair(in[1],false));
            }
        }
        for(Integer i : mp.keySet()){
            for(pair p : mp.get(i)){
                if(p.first){
                    System.out.print("- ");
                }else {
                    System.out.print(p.s+" ");
                }
            }
        }

    }
}
