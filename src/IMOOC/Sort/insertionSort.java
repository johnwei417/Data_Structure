package IMOOC.Sort;

/**
 * honglinwei created on 5/4/20 inside the package - IMOOC.Sort
 */
public class insertionSort<E extends Comparable<E>>{
    public static void main(String[] args) {
        Comparable[] a = {10,9,8,7,6,5,4,3,2,1};
        insertionSort insertionSort = new insertionSort();
        insertionSort.insertionSort(a);
        for(Comparable a1: a){
            System.out.println(a1);
        }
    }

    public void insertionSort(E[] arr){
        for (int i = 1; i < arr.length; i++) {

            for(int j = i; j > 0; j--){
                if(arr[j].compareTo(arr[j-1]) < 0 ){
                    swap(arr, j, j -1);
                }else{
                    break;
                }
            }
        }
    }

    private void swap(E[] arr, int j, int i) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
