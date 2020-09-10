package IMOOC.LinkedList;

import IMOOC.Queue.Queue;

/**
 * honglinwei created on 3/27/20 inside the package - IMOOC.LinkedList
 */
public class LinkedListQueue<E> implements Queue<E> {

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public void enqueue(E e) {
        if(tail == null) {
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException();
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }
        size--;

        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException();
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null){
            res.append(cur + " -> " );
            cur = cur.next;
        }
        res.append(" NULL tail");
        return res.toString();

    }

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.next =next;
            this.e = e;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }


    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for(int i = 0; i < 10; i ++){
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);

            if(i % 3 == 2 ){
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }



}
