package IMOOC.Trie;

import java.util.TreeMap;

/**
 * honglinwei created on 4/29/20 inside the package - IMOOC.Trie
 */
public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

//    public void add(String word){
//
//        Node cur = root;
//
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if(cur.next.get(c)==null){
//                cur.next.put(c,new Node());
//            }
//            cur = cur.next.get(c);
//        }
//        if(!cur.isWord) {
//            cur.isWord = true;
//            size++;
//        }
//    }

    public void add(String word){
        add(root, word , 0);
    }

    public void add(Node node, String word, int index){
        if(index == word.length()){
            if(!node.isWord){
                node.isWord = true;
                size++;
            }
            return;
        }

        char c = word.charAt(index);
        if(node.next.get(c) == null){
            node.next.put(c, new Node());
        }
        add(node.next.get(c), word, index + 1);
    }

    //check if word in the trie
//    public boolean contains(String word){
//        Node cur = root;
//
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if(cur.next.get(c) == null)
//                return false;
//            cur = cur.next.get(c);
//        }
//        return cur.isWord;
//    }

    public boolean contains(String word){
        return contains(root, word, 0);
    }

    public boolean contains(Node node, String word, int index){
        if(index == word.length()){
           return node.isWord;
        }
        char c = word.charAt(index);
        if(node.next.get(c) == null){
            return false;
        }
        return contains(node.next.get(c), word, index +1);
    }


    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
}
