package term;

import java.util.LinkedList;

/**
 * Created by Sudipta Banik on 09-07-2017.
 */
public class TreeNode<T extends Comparable<T>> {
    protected T data;
    protected TreeNode<T> left = null;
    protected TreeNode<T> right = null;

    TreeNode(T x){
        this.data = x;
    }

    T getData() {
        return data;
    }
    private void setData(T data) {
        this.data = data;
    }
    TreeNode<T> getLeft() {
        return left;
    }
    private void setLeft(TreeNode<T> left) {
        this.left = left;
    }
    TreeNode<T> getRight() {
        return right;
    }
    private void setRight(TreeNode<T> right) {
        this.right = right;
    }

    void insert(T toAdd){
        if(this.getData().compareTo(toAdd)>0){
            if(getLeft() == null){
                setLeft(new TreeNode<>(toAdd));
            }else{
                getLeft().insert(toAdd);
            }
        }else{
            if(getRight() == null){
                setRight(new TreeNode<>(toAdd));
            }else{
                getRight().insert(toAdd);
            }
        }
    }

    String inOrderTraversal(){
        if(this == null){
            return "";
        }else{
            StringBuilder str = new StringBuilder("");
            if(getLeft()!=null)str.append(getLeft().inOrderTraversal());
            str.append(getData()+" ");
            if(getRight()!=null)str.append(getRight().inOrderTraversal());
            return str.toString();
        }
    }

    boolean contains(T toSearch){
        if(getData().compareTo(toSearch)==0){
            System.out.print(getData()+" ");
            return true;
        }else{
            if(getData().compareTo(toSearch)>0){
                if(getLeft()==null){return false;}
                else {
                    System.out.print(getData()+" ");
                    return getLeft().contains(toSearch);
                }
            }else{
                if(getRight()==null){return false;}
                else {
                    System.out.print(getData()+" ");
                    return getRight().contains(toSearch);
                }
            }
        }
    }

    public T predecessor(){
        return getData(); // todo
    }
    public T minimum(){
        TreeNode<T> temp = this;
        while (temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp.getData();
    }
    public T maximum(){
        TreeNode<T> temp = this;
        while (temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp.getData();
    }

    public int height(){
        if(this == null){
            return -1;
        }else{
            int lh = -1, rh = -1;
            if(getLeft()!=null){
                lh = getLeft().height();
            }
            if(getRight()!=null){
                rh = getRight().height();
            }
            return 1 + Math.max( lh,rh );
        }
    }
    public boolean isBST(T leftBound,T rightBound){
        if(this == null)return true;
        else{
            if(getData().compareTo(leftBound)>=0 && getData().compareTo(rightBound)<0){
                return (getLeft() == null ||getLeft().isBST(leftBound,getData()) ) &&
                        (getRight() == null ||getRight().isBST(getData(),rightBound));
            }else{
                return false;
            }
        }
    }


    public <T extends Comparable<T>> TreeNode<T> delete(TreeNode<T> it, T x) {
        if(it == null)return it;
        if(it.getData().compareTo(x)==0) {
            if(it.getRight() == null && it.getLeft() == null){
                return it;
            }else if(it.getLeft() == null && it.getRight()!=null){
                return it.getLeft();
            }else if(it.getLeft()!=null && it.getRight() == null){
                return it.getRight();
            }else{
                if(getLeft().height() > getRight().height()){
                    T maxLeft = (T) getLeft().maximum();
                    it.setData(maxLeft);
                    it =  delete(it.getLeft() , maxLeft);
                }else {
                    T minRight = (T) getRight().minimum();
                    it.setData(minRight);
                    it =  delete(it.getRight(), minRight);
                }
            }
        }else if(it.getData().compareTo(x)>0){
            it = getLeft().delete(it,x);
        }else{
            it =  getRight().delete(it,x);
        }
        return it;
    }

    public void printBottom() {
        if(this.getLeft() == null && this.getRight() == null){
            System.out.print(this.getData() + " ");
        }else{
            if(this.getLeft() != null)this.getLeft().printBottom();
            if(this.getRight() != null)this.getRight().printBottom();
        }
    }

    public void embedNodes(LinkedList<T> list) {
        if(this == null){
            return;
        }else{
            if(this.left !=null)embedNodes(list);
            list.add(this.data);
            if(this.right !=null)embedNodes(list);
        }
    }
}
