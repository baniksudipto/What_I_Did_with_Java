package app;

public class Node {

    public int data;
    public Node prev = null;
    public Node next = null;
    public Node(int _data , Node _prv, Node _nxt){
        this.data = _data;
        this.prev = _prv;
        this.next = _nxt;
    }


    public Node(int d) {
        this.data = d;
        this.prev = null;
        this.next = null;
    }


}
