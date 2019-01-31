package com.sh.zfc.tree;

public class RedBlackTree<K extends Comparable<? super K>,T extends Comparable<? super T>> {

    public static final boolean RED = false;
    public static final boolean BLACK = true;

    private RedBlackTreeNode<K,T> root;

    public RedBlackTreeNode<K,T> getRoot() {
        return root;
    }

    public void setRoot(RedBlackTreeNode<K , T> root) {
        this.root = root;
    }

    public RedBlackTree(RedBlackTreeNode<K , T> root) {

        this.root = root;
    }

    public RedBlackTreeNode<K,T> rotateLeft(RedBlackTreeNode<K,T> h){
        RedBlackTreeNode<K,T> x= h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        x.setColor(h.getColor());
        h.setColor(RED);
        return x;
    }

    public RedBlackTreeNode<T> rotateRight(RedBlackTreeNode<T> h){
        RedBlackTreeNode<T> x= h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        x.setColor(h.getColor());
        h.setRed();
        return x;
    }

    public void flipColors(RedBlackTreeNode<T> h){
        h.setRed();
        h.getRight().setBlack();
        h.getLeft().setBlack();
    }

    public void insrtIntoBlack(RedBlackTreeNode<T>  newNode){
        root = insertIntoBlack(root , newNode);
        root.setBlack();
    }

    private RedBlackTreeNode<T> insertIntoBlack(RedBlackTreeNode<T> root, RedBlackTreeNode<T> newNode) {
        if (root == null) {
            newNode.setRed();
            return newNode;
        }

        if (root.getValue().compareTo(newNode.getValue()) < 0) {
            insertIntoBlack(root.getRight() , newNode);
        }else {
            insertIntoBlack(root.getLeft(),newNode);
        }

        if (!root.isRed()) {
            if (root.getLeft().isRed() && root.getRight().isRed()) {
                flipColors(root);
                return root;
            }else if(!root.getLeft().isRed() && root.getRight().isRed()){
                return rotateLeft(root);
            }
            return root;
        }else{

        }

    }


    public static class RedBlackTreeNode<K , T>{
        K key;
        T value;
        RedBlackTreeNode<K ,T> left,right;
        //true : RED, false: Black
        boolean color;

        public RedBlackTreeNode(K key , T value, boolean color) {
            this.value = value;
            this.color = color;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public RedBlackTreeNode<K, T> getLeft() {
            return left;
        }

        public void setLeft(RedBlackTreeNode<K, T> left) {
            this.left = left;
        }

        public RedBlackTreeNode<K, T> getRight() {
            return right;
        }

        public void setRight(RedBlackTreeNode<K, T> right) {
            this.right = right;
        }

        public boolean getColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }
}
