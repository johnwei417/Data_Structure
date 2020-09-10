package IMOOC.Sort;

/**
 * honglinwei created on 5/4/20 inside the package - IMOOC.Sort
 */
public class mergeSort2 {
    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        mergeSort2 mergeSort2 = new mergeSort2();
        mergeSort2.mergeSortBU(a, 10);
        for(int a1: a){
            System.out.println(a1);
        }
    }

    public void mergeSortBU(int[] arr, int n){
        for(int sz = 1; sz <= n; sz += sz)
            for(int i = 0; i + sz < n; i += sz + sz)
                //对arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行并归
                merge(arr, i, i + sz -1, Math.min(i + sz + sz - 1, n -1));
    }

    private void merge(int[]arr, int left, int mid, int right) {
        int[] aux = new int[right - left + 1];
        // 把我们在这个函数中，要处理的arr[l, r]这段数组中的内容，复制到aux中。

        for (int i = left; i <= right; i++) {
            aux[i - left] = arr[i];
            // 这里为什么要减去l？因为aux是这个函数里面创建的临时空间，索引是从0开始的！
        }
        int i = left, j = mid + 1; // i 和 j 就是PPT中两个红色箭头
        for (int k = left; k <= right; k++) {
            // k 就是PPT中的拿一个蓝色箭头。
            // 循环中，每次决定arr[k]是谁。
            // arr[k]的值，只能从aux[i - l]和aux[j - l]中选择
            if (i > mid) {
                // 如果左半部分元素已经全部处理完毕
                // arr[k] 是 aux[j - l]
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                // 如果右半部分元素已经全部处理完毕
                // arr[k] 是 aux[i - l]
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left] < aux[j - left]) {
                // 左半部分所指元素 < 右半部分所指元素
                // arr[k] 是 aux[i - l]
                arr[k] = aux[i - left];
                i++;
            } else {
                // 左半部分所指元素 >= 右半部分所指元素
                // arr[k] 是 aux[j - l]
                arr[k] = aux[j - left];
                j++;
            }
        }
    }
}
