package IMOOC.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * honglinwei created on 3/28/20 inside the package - IMOOC.BST
 */
public class BST <E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left, right;
        public Node(E e){
            this.e = e;
            right = null;
            left = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    //insert new elements into the tree
    public void add(E e){
        root  =  add(root, e);
    }


    //add element recursively
    //use node as root of the BST
    //return root of bst after insertion
    private Node add(Node node, E e) {
        if(node == null){
            size++;
           return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }


        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){

        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else if(e.compareTo(node.e) < 0){
            return contains(node.right, e);
        }

        return false;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    public void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);

            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right !=null){
                queue.add(cur.right);
            }
        }
    }


    public E min(){
        if(size == 0){
            throw new IllegalArgumentException("BST is empty");
        }

        return min(root).e;
    }

    private Node min(Node node){
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }


    public E max(){

        return max(root).e;
    }

    public E removeMin(){
        E ret = min();
        root = removeMin(root);

        return ret;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E ret = max();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }



    private Node max(Node node){
        if(node.right == null){
            return node;
        }

        return max(node.right);
    }

    public void remove(E e){
        root = remove(root, e);
    }

    /**
     * remove any elements from tree
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e){

        if(node == null){
            return null;
        }

        if(e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ) {
            node.right = remove(node.right, e);

            return node;
        }
        else {
            //e == node.e

            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = min(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        generateBSTString(root, 0, res);
        return res.toString();
    }


    private void generateBSTString(Node node, int depth, StringBuffer res){
        if(node == null){
            res.append(generateDepthString(depth)+ "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth+1, res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth){
        StringBuffer res= new StringBuffer();
        for (int i = 0; i < depth ; i++) {
            res.append("--");

        }
        return res.toString();
    }

}
