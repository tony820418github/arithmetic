package com.sh.zfc.tree;
/*/
    二三树的实现比较复杂，本文试着实现，逻辑太多，不写了，直接看红黑树
 */
import java.util.Collections;

public class TwoThreeTree<T extends Comparable<? super T>> {
    TwoThreeNode<T> root ;

    public TwoThreeNode<T> search(T t, TwoThreeNode<T> node){
        if (node.getLeft()==null && node.getRight()==null) {
            return node;
        }
        if (node.getType() == TwoThreeNode.TWO_TYPE) {
            if(t.compareTo(node.getDateleft()) < 0){
                return search(t , node.getLeft());
            }else {
                return search(t,node.getRight());
            }
        }else {
            if(t.compareTo(node.getDateleft()) < 0){
                return search(t , node.getLeft());
            }else if(t.compareTo(node.getDatarignt())<0) {
                return search(t,node.getMinddle());
            }else {
                return search(t,node.getRight());
            }
        }
    }


    public TwoThreeNode<T> insert(T t){
        TwoThreeNode<T> node = search( t , root);
        if (node.getType() == TwoThreeNode.TWO_TYPE) {
            if (t.compareTo(node.getDateleft()) <0 ) {
                node.setDatarignt(node.getDateleft());
                node.setDateleft(t);
            }
        }else{
            if (node.getParent() == null) {
                TwoThreeNode<T> newRoot;
                TwoThreeNode<T> newRootleft;
                TwoThreeNode<T> newRootright;
                if(t.compareTo(node.getDateleft()) < 0){
//                    newRootleft = new TwoThreeNode<>(TwoThreeNode.TWO_TYPE,t,null ,null,node.getL)
//                    newRootright
//                    newRoot = new TwoThreeNode<>(TwoThreeNode.TWO_TYPE,node.getLeft(),null ,null,)
                }else if(t.compareTo(node.getDatarignt())<0) {
                    return search(t,node.getMinddle());
                }else {
                    return search(t,node.getRight());
                }

            }else {
                if(t.compareTo(node.getDateleft()) < 0){
                    return search(t , node.getLeft());
                }else if(t.compareTo(node.getDatarignt())<0) {
                    return search(t,node.getMinddle());
                }else {
                    return search(t,node.getRight());
                }
            }

        }
        return root;
    }




    public static class TwoThreeNode<T> {
        public static final int TWO_TYPE = 2;
        public static final int THREE_TYPE = 3;

        TwoThreeNode parent,left,right,minddle;
        T dateleft , Datarignt;
        int type;

        public TwoThreeNode(int type , T dateleft, T datarignt, TwoThreeNode parent, TwoThreeNode left,TwoThreeNode minddle, TwoThreeNode right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.minddle = minddle;
            this.dateleft = dateleft;
            Datarignt = datarignt;
            this.type = type;
        }

        public TwoThreeNode getParent() {
            return parent;
        }

        public void setParent(TwoThreeNode parent) {
            this.parent = parent;
        }

        public TwoThreeNode getLeft() {
            return left;
        }

        public void setLeft(TwoThreeNode left) {
            this.left = left;
        }

        public TwoThreeNode getRight() {
            return right;
        }

        public void setRight(TwoThreeNode right) {
            this.right = right;
        }

        public TwoThreeNode getMinddle() {
            return minddle;
        }

        public void setMinddle(TwoThreeNode minddle) {
            this.minddle = minddle;
        }

        public T getDateleft() {
            return dateleft;
        }

        public void setDateleft(T dateleft) {
            this.dateleft = dateleft;
        }

        public T getDatarignt() {
            return Datarignt;
        }

        public void setDatarignt(T datarignt) {
            Datarignt = datarignt;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
