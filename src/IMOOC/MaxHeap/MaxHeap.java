package IMOOC.MaxHeap;

/**
 * honglinwei created on 4/4/20 inside the package - IMOOC.MaxHeap
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }
    //heaplify
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0 ; i--) {
            siftDown(i);
        }
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException();
        }
        return (index - 1)/2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }
//
//    private void siftUp(int k){
//
//        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
//            data.swap(k, parent(k));
//            k = parent(k);
//        }
//    }

    //get max value in the heap
    public E findMax(){
        if(data.getSize() ==0 ){
            throw new IllegalArgumentException();
        }
        return data.get(0);
    }

    //recursion siftup
    private void siftUp(int k){
        E e = data.get(k);
        if(k == 0 || e.compareTo(data.get(parent(k))) < 0){
            return;
        }
        data.swap(k, parent(k));
        siftUp(parent(k));
    }

    public E extractMax(){
        E ret = findMax();

        //swap fist element with last element in the heap
        data.swap(0, data.getSize() -1);
        //remove last element from the heap;
        data.removeLast();

        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        while(leftChild(k)<data.getSize()){
            int j = leftChild(k);
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
                //data[j] is the max value in leftchild and rightchild
            }
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //extract max value from the heap and add new element
    public E replace(E e){
        E ret = findMax();

        data.set(0, e);
        siftDown(0);
        return ret;
    }


}

