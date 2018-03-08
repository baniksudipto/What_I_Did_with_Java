
import java.util.*;

public class LCS {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();int m = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            b[i] = sc.nextInt();
        }

        int[][] table = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                table[i][j] = 0;
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1] == b[j-1])    table[i][j]=1 + table[i-1][j-1] ;
                else table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
            }
        }

        int i=n  ,j=m;

        while(i>0 && j>0){
            if(a[i-1] == b[j-1]){
                list.addFirst(a[i-1]);
                i--;
                j--;
            }else if(table[i][j] > table[i][j-1]){
                i--;
            }else{
                j--;
            }
        }
        for(Integer x:list){
            System.out.print(x+" ");
        }
    }
}