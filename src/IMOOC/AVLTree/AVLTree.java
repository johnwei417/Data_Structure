package IMOOC.AVLTree;

import IMOOC.Array.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * honglinwei created on 3/28/20 inside the package - IMOOC.BST
 */
public class AVLTree<K extends Comparable<K>,V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            right = null;
            left = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    private int getHeight(Node node){
        if(node == null)
            return 0;
        return node.height;
    }


    private int getBalanceFactor(Node node){
        if(node == null)
            return 0;
        return getHeight(node.left)- getHeight(node.right);
    }

    private boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size() ; i++) {
            if(keys.get(i-1).compareTo(keys.get(i))> 0){
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys){
        if(node == null){
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    //insert new elements into the tree
    public void add(K key, V value){
        root  =  add(root, key, value);
    }


    //add element recursively
    //use node as root of the BST
    //return root of bst after insertion
    private Node add(Node node, K key, V value) {
        if(node == null){
            size++;
           return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }else{
            node.value = value;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //balance factor;
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1){
            System.out.println("unbalanced: "+ balanceFactor);
        }
        return node;
    }


}
