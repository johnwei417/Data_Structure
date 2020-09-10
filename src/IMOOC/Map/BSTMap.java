package IMOOC.Map;

/**
 * honglinwei created on 4/3/20 inside the package - IMOOC.Map
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K , V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right =null;
        }
    }
    private Node root;
    private int size;
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node root, K key, V value){
        if(root == null){
            size ++;
            return new Node(key, value);
        }
        if(key.compareTo(root.key) < 0){
            root.left = add(root.left, key, value);
        }
        else if(key.compareTo(root.key) > 0){
            root.right = add(root.right, key, value);
        }else{
//            key.compareTo(root.key);
            root.value = value;
        }
        return root;
    }

    private Node getNode(Node node, K key){
        if(node == null){
            return null;
        }

        if(key.compareTo(node.key)== 0){
            return node;
        }else if(key.compareTo(node.key)< 0){
            return getNode(node.left,key);
        }else{
            return getNode(node.right, key);
        }
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null ? true: false;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null: node.value;
    }

    @Override
    public void set(K key, V value) {

        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key +"does not exist!");
        }
        node.value = value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
