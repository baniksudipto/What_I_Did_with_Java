package term;

import java.util.Iterator;

/**
 * Created by Sudipta Banik on 09-07-2017.
 */
public class Dictionary {
    protected TrieNode root;

    Dictionary(){
        root = new TrieNode();
    }
    public void add(String s){
        root.add(s,0);
    }
    public int count(String s){
        return root.findCount(s,0);
    }

    public boolean Match(String s){
        return root.Match(s,0);
    }
    public int countRec(String s){return root.countHardWay(s,00);}
    public void remove(String s){
        root.delete(s,0);
    }

}
