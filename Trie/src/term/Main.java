package term;

import java.util.Scanner;
import java.util.Stack;

public class Main {



    public static void main(String[] args) {
        Dictionary d = new Dictionary();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0){
            String ch = sc.next();
            switch (ch){
                case "add":{
                    d.add(sc.next());
                   break;
                }case "find":{
                    System.out.println(d.count(sc.next()));
                    break;
                }case "count":{
                    System.out.println(d.countRec(sc.next()));
                    break;
                }default:{
                    break;
                }
            }
        }


    }
}
