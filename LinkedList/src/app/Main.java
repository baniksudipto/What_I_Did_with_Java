package app;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();

        int k = sc.nextInt();
        while (k-- > 0){
            String ch = sc.next();
            switch (ch){
                case "add":
                    ll.append(sc.nextInt());
                    break;
                case "addSorted":
                    ll.addSorted(sc.nextInt());
                    break;
                case "reverse":
                    ll.reverse();
                    break;
                case "print":
                    ll.iterate();
                    break;
                case "contains":
                    System.out.println(ll.contains(sc.nextInt()));
                    break;
                case "delete":
                    ll.delete(sc.nextInt());
                    break;
                case "sort":
                    ll.quickSort();
                    break;
                default:
                    break;
            }
        }
        sc.close();


    }


}