package IMOOC.Stack;


import IMOOC.Array.Array;

/**
 * honglinwei created on 3/26/20 inside the package - IMOOC.Stack
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }


    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuffer res = new StringBuffer();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize() ; i++) {
            res.append(array.get(i));
            if(i != array.getSize() -1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
