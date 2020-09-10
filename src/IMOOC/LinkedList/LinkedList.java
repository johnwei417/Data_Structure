package IMOOC.LinkedList;

/**
 * honglinwei created on 3/26/20 inside the package - IMOOC.LinkedList
 */
public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }


    private Node dummyhead;
    private Node head;
    int size;


    //constructor to initialize the instance
    public LinkedList(){
        dummyhead = new Node(null, null);
        size = 0;
    }

    //get size of the linkedlist
    public int getSize(){
        return size;
    }

    //check if linkedlist is empty
    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, E e){

        if(index <  0 || index > size){
            throw new IllegalArgumentException();
        }

////        if(index == 0){
////            addFirst(e);
////        }else{
//        Node prev = dummyhead;
//        for(int i = 0; i < index; i++){
//            prev = prev.next;
//        }
////            Node node  = new Node(e);
////            node.next = prev.next;
////            prev.next = node;
//        prev.next = new Node(e, prev.next);
//            size ++;

/**
 * add with recursion
 */
        Node prev = dummyhead;
        ReAdd(e, prev, 0 , index);
        size++;

    }

    private void ReAdd(E e, Node prev, int cur, int index){
       if(cur == index){
          Node newNode = new Node(e);
          newNode.next = prev.next;
          prev.next = newNode;
           return;
       }
        ReAdd(e, prev.next, cur + 1, index);
    }

    public void addFirst(E e){
       add(0, e);
   }

    public void addLast(E e){
        add(size, e);
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Illegal index");
        }

        Node cur = dummyhead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;

        }

        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException();
        }

        Node cur = dummyhead.next;
        Node node = new Node(e);
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node cur = dummyhead.next;
        while(cur != null){
            if(cur.e.equals(e))
                return true;

            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if(index <0 || index>= size){
            throw new IllegalArgumentException();
        }

        Node prev = dummyhead;
//        for (int i = 0; i < index; i++) {
//            prev = prev.next;
//        }
//        Node delNode = prev.next;
//        E ret = delNode.e;
//        prev.next  = delNode.next;
//        delNode.next = null;

        E ret = removeRecusively(prev, 0, index);
        size--;

        return ret;
    }

    private E removeRecusively(Node prev, int cur, int index){
        if(cur == index){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.e;
        }
        return removeRecusively(prev.next, cur + 1, index);
    }


    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }
    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        Node cur = dummyhead.next;
        while(cur != null){
            res.append(cur+" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
