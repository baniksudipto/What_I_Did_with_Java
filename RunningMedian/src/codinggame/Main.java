package codinggame;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class MedianHeap{
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        void insert(Integer x){
            if(left.isEmpty()){
                left.add(x);return;
            }
            if(x > left.peek()){
                right.add(x);
            }else{
                left.add(x);
            }
            stabilize();
        }
        private void stabilize() {
            if(left.size() < right.size()){
                left.add(right.poll());
            }else if(right.size() < left.size()){
                right.add(left.poll());
            }
        }
        void printSize(){
            if(!left.isEmpty())System.out.print(left.peek()+"  ");
            if(!right.isEmpty())System.out.print(right.peek() + "   " );
            System.out.println(left + "  " + right);
        }
        void printmid(){
            double mid = 0;
            if(left.size() == right.size()){
                mid = (left.peek() + right.peek())/2.0;
            }else if(left.size() > right.size()){
                mid = left.peek();
            }else{
                mid = right.peek();
            }
            System.out.printf("%.1f",mid);
        }
        void delete(Integer x){
            left.remove(x);
            right.remove(x);
        }

    }

    public static void main(String[] args) {
	    MedianHeap hp = new MedianHeap();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            hp.insert(sc.nextInt());
            hp.printSize();
        }
        for(int i=0;i<n;i++){
            hp.delete(sc.nextInt());
            hp.printSize();
        }

    }
}
