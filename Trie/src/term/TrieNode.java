package term;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Sudipta Banik on 08-07-2017.
 */
public class TrieNode {
    protected Map<Character,TrieNode> branches = new TreeMap<>();;
    protected int size = 0;
    protected boolean isEnd = false;


    protected void add(String s,int i){
        if(i < s.length()){
            branches.putIfAbsent(s.charAt(i),new TrieNode());
            branches.get(s.charAt(i)).add(s,i+1);

        }else{
            isEnd = true;
        }
        size++;
    }

    protected int findCount(String s,int i){
        if(i==s.length()){
            return size;
        }else{
            if(branches.get(s.charAt(i))!=null){
                return branches.get(s.charAt(i)).findCount(s,i+1);
            }else{
                return 0;
            }
        }
    }
    protected boolean delete(String s,int i){
        if(i == s.length()){
            if(isEnd){
                System.out.println(s + " Deleted");
                isEnd = false;
                return branches.size() == 0;
            }else{
                return false;
            }
        }else{
            char c = s.charAt(i);
            if(branches.get(c)==null){
                return false;
            }else{
                if(branches.get(c).delete(s,i+1)){
                    branches.remove(c);
                    return branches.size() == 0;
                }
                return false;
            }
        }
    }

    protected boolean Match(String s,int i){
        if(i == s.length()){
            return true||isEnd;
        }else{
            if(branches.get(s.charAt(i))==null){
                return false;
            }else {
                return branches.get(s.charAt(i)).Match(s,i+1);
            }
        }
    }
    public int countHardWay(String sr,int i){
        if(isEnd && sr.length() == i){
            return 1;
        }else{
            int s=0;
            for(char c: branches.keySet()){
                s += branches.get(c).countHardWay(sr,i+1);
            }
            return s;
        }
    }
}
