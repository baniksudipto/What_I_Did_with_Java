package term;

/**
 * Created by Sudipta Banik on 08-07-2017.
 */
public class SegmentTree {

    int size ;
    int[] arr;
    int in = 0;

    SegmentTree(int x){
        size =x;
        arr = new int[2*x - 1];
        in = size-1;
    }

    private int parent(int i){
        return arr[(i-1)/2];
    }
    private int leftClild(int i){
        return arr[1 + 2*i];
    }
    private int rightChild(int i){
        return arr[2+ 2*i];
    }

    public void add(int x){
        try{
            arr[in]=x;
            in++;
        }catch(Exception e){
            //
        }
    }
    public void initiate(){
        int i = size-2;
        while(i>=0){
            arr[i] = Math.min(leftClild(i),rightChild(i));
        }
    }
    public int minInRange(int l,int r){
        l+= (size-1);
        r+= (size-1);
        int min = Integer.MAX_VALUE;
        while(l<r){

            l = (l-1)/2;
            r = (r-1)/2;
        }
        return Math.min(arr[l],arr[r]);
    }
}
