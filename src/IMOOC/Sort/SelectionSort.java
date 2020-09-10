package IMOOC.Sort;

/**
 * honglinwei created on 5/3/20 inside the package - IMOOC.SelectionSort
 */
public class SelectionSort<E extends Comparable<E>>{

    public static void main(String[] args) {
        Comparable[] a = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(a);
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }

    public void selectionSort(E[] arr){
      int n = arr.length;
      for(int i = 0; i < n; i ++){
          int minIndex = i;
          for(int j = i + 1; j < n; j++){
              if(arr[j].compareTo(arr[minIndex]) < 0){
                  minIndex = j;
              }
          }
          swap(arr, i, minIndex);
      }
    }

    private void swap(E[] arr, int i, int minIndex) {
        E temp;
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
