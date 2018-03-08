import java.util.HashMap;
import java.util.Scanner;
/**
 * Created by Sudipta Banik on 18-07-2017.
 */
public class BinominalCoefficient {
    static class pair{
        public int n;
        public int r;
        pair(int n,int r){this.n=n;this.r=r;}
    }
    static HashMap<pair,Long> mp = new HashMap<>();
    public static long C(int n,int r){
        if(n==0 || n==r){return 1;}
        else{
//            long k = 0;
//            pair p = new pair(n-1,r-1);
//            if(mp.containsKey(p)) k = mp.get(p);
//            else{
//                mp.put(p,C(n-1,r-1));
//                k += mp.get(p);
//            }
//
//            p = new pair(n-1,r);
//            if(mp.containsKey(p)) k += mp.get(p);
//            else{
//                mp.put(p,C(n-1,r));
//                k += mp.get(p);
//            }
//
//            return k;
            return C(n-1,r-1) + C(n-1,r);
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        mp.clear();
        System.out.println(C(sc.nextInt(),sc.nextInt()));
    }
}
