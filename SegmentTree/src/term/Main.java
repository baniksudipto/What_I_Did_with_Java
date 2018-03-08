package term;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    SegmentTree st = new SegmentTree(n);
	    for(int i=0;i<n;i++){
	        st.add(sc.nextInt());
        }
        System.out.print("\n Enter no of queries : ");
        int q = sc.nextInt();
        st.initiate();
        for(int i=0;i<q;i++){
            System.out.println(st.minInRange(sc.nextInt(),sc.nextInt()));
        }
    }
}
