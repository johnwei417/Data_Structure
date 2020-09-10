package IMOOC.LinkedList;

/**
 * honglinwei created on 3/27/20 inside the package - IMOOC.LinkedList
 */
public class ListNode {
     public int val;
     public ListNode next;

    public ListNode(int x){
        val  = x;
    }

    public ListNode(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException();
        }

        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1; i< arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString(){
        StringBuffer res= new StringBuffer();
        ListNode cur = this;
        while(cur != null){
            res.append(cur.val +" -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
