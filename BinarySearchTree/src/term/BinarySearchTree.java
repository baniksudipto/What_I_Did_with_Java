package term;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Sudipta Banik on 09-07-2017.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root = null;

    public void insert(T data){
        if(root ==  null){
            root = new TreeNode<>(data);
        }else {
            root.insert(data);
        }
    }

    public String inOrderTraversal(){
        return root.inOrderTraversal();
    }
    public LinkedList<T> returnList(){
        if(root != null){
            LinkedList<T> list = new LinkedList<>();
            root.embedNodes(list);
            return list;
        }else{
            return null;
        }
    }
    public boolean contains(T toSearch){return root.contains(toSearch);}
    public T Minimum(){
        if(root == null){
            return null;
        }else {
            return root.minimum();
        }
    }
    public int getHeight(){
        return root.height();
    }
    public void LevelOrderTraversal(){
        if(root == null){
            return;
        }else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                System.out.print(temp.getData()+" ");
                if(temp.getLeft()!=null)queue.add(temp.getLeft());
                if(temp.getRight()!=null)queue.add(temp.getRight());
            }
        }
    }
    public boolean isBST(T a,T b){
        return root.isBST(a,b);
    }

    public boolean DeleteData(T x){
        if(root == null){
            return false;
        }else{
            try{
                root = root.delete(root,x);
                return true;
            }catch (Exception e){
                return false;
            }
        }
    }
    public void printBottom(){
        root.printBottom();
    }

//    private void delete(TreeNode it , T x){
//        if(it == null){
//            return;
//        }
//        if(it.getData().compareTo(x)==0){
//            if(it.getRight() == null && it.getLeft()==null){
//                it = null;
//            }else if(it.getLeft() == null && it.getRight() !=null){
//                it = it.getRight();
//            }else if(it.getLeft() !=null && it.getRight() == null){
//
//            }else{
//                int leftH = it.getLeft().height() , rightH = it.getRight().height();
//                if(leftH <= rightH){
//                    TreeNode<T> temp = it.getRight();
//                    while (temp.getLeft()!=null){
//                        temp = temp.getLeft();
//                    }
//                    it.setData(temp.getData());;
//                    delete(it.getRight(), (T) it.getData());
//                }else{
//                    TreeNode<T> temp = it.getLeft();
//                    while (temp.getRight()!=null){
//                        temp = temp.getRight();
//                    }
//                    it.setData(temp.getData());
//                    temp = null;
//                    delete(it.getLeft(), (T) it.getData());
//                }
//        }
//        }else if(it.getData().compareTo(x)>0){
//            delete(it.getLeft(),x);
//        }else{
//            delete(it.getRight(),x);
//        }
//    }
}
