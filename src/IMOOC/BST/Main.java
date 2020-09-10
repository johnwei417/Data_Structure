package IMOOC.BST;

/**
 * honglinwei created on 3/28/20 inside the package - IMOOC.BST
 */
public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for(int num: nums){
            bst.add(num);
        }

//        bst.preOrder();
//
//        System.out.println();
//        bst.inOrder();
//
//
//        System.out.println();
//        bst.postOrder();

        bst.remove(6);
        bst.bfs();


      //  System.out.println(bst);
    }
}
