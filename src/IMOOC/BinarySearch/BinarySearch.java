package IMOOC.BinarySearch;

import java.util.Arrays;

/**
 * Time complexity for binary search is O(logN)
 * depth of recursion is logN
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,9,6,4,2,5,7,2,10};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach((i)->{
            System.out.print(i + " ");
        });
        System.out.println();
        int target  = 1;
        System.out.println(binarySearch(arr,0, arr.length, target));
    }

    //recursion way to do binary search
    public static int binarySearch(int[] arr, int l, int r, int target){
        if(l > r){
            return -1;
        }
        int mid = l + (r-l)/2;
        if(arr[mid] == target )
            return mid;
        else if(arr[mid] > target)
            return binarySearch(arr, l, mid - 1, target);
        else
            return binarySearch(arr, mid + 1, r, target);
    }

    //iterative way to do binary search
    public static int bs(int[] arr, int l, int r, int target){
        if(l > r){
            return -1;
        }
        while(l < r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}
