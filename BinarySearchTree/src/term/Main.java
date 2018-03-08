package term;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = {4,2,1,3,6,5,7};
        for(int i=0;i<7;i++){
            bst.insert(a[i]);
        }
        System.out.println(bst.returnList());
    }
}
