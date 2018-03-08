package app;

import java.util.Map;

/**
 * Created by Sudipta Banik on 04-07-2017.
 */
public class LinkedList {

    protected Node head, tail;
    int len;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.len = 0;
    }

    public void addSorted(int d) {
        Node t = new Node(d);
        if (head == null) {
            head = t;
            tail = t;
        } else {
            Node it = head;
            while (it.next != null && it.data < d) {
                it = it.next;
            }
            if (it == tail && it.data < d) {
                it.next = t;
                t.prev = it;
                tail = t;
            } else if (it.prev == null) {
                it.prev = t;
                t.next = it;
                head = t;
            } else {
                it.prev.next = t;
                t.prev = it.prev;
                t.next = it;
                it.prev = t;
                tail = it;
            }
        }
        len++;
    }

    public void append(int _d) {
        Node tmp = new Node(_d, null, null);
        if (this.head == null) {
            head = tmp;
            tail = tmp;
        } else {
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
        len++;
    }

    public void prepend(int _d) {
        Node tmp = new Node(_d);
        if (this.head == null) {
            head = tmp;
            tail = tmp;
        } else {
            tmp.next = head;
            head = tmp;
        }
        len++;
    }

    public void iterate() {
        try {
            Node it = head;
            while (it != null) {
                System.out.print(it.data + " ");
                it = it.next;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    boolean contains(int d) {
        Node it = head;
        while (it != null) {
            if (it.data == d) return true;
            it = it.next;
        }
        return false;
    }

    void reverse() {
        if (head == null || head.next == null) {
            return;
        } else {
            Node it = null;
            while (head != null) {
                it = head;
                swap(head.prev, head.next);
                head = head.prev;
            }
            head = it;
        }
    }

    private <T> void swap(T prev, T next) {
        T t = prev;
        prev = next;
        next = t;
    }

    public void delete(int i) {
        if (head == null)return;
        else {
            Node it = head;
            while (it !=null) {
                if(it.data == i)break;
                it = it.next;
            }
            if(it!=null){
                if(it == head){
                    if(it.next == null){
                        head = null;
                    }else{
                        it = it.next;
                        head = it;
                    }
                }else if(it.next == null){
                    it.prev.next = null;
                }else{
                    it.prev.next = it.next;
                    it.next.prev = it.prev;
                }
            }
        }

    }

    public void sort() {
        sortUtil(head);
    }
    public void sortUtil(Node it){
        if(it == null)return;
        else {
            int min = it.data;
            Node minPtr = null;
            Node ptr = it.next;
            while (ptr!=null){
                if(ptr.data < min){
                    min = ptr.data;
                    minPtr = ptr;
                }
                ptr = ptr.next;
            }
            if(minPtr!=null){
                min = it.data;
                it.data = minPtr.data;
                minPtr.data = min;
            }
            sortUtil(it.next);
        }
    }



    public void quickSort(){
        qsort(head);
    }

    private void qsort(Node it) {
        if(it == null || it.next == null)return;
        else if(it.next.next == null){
            if(it.data > it.next.data){
                int temp = it.next.data;
                it.next.data = it.data;
                it.data = temp;
            }
        }else{
            Node fast = it;

        }
    }
}