package IMOOC.LinkedList;

/**
 * honglinwei created on 3/27/20 inside the package - IMOOC.LinkedList
 */
public class Leetcode_203 {
    public ListNode removeElements(ListNode head, int val) {
//        while(head !=null && head.val == val){
////            ListNode delNode = head;
////            head = head.next;
////            delNode.next = null;
//            head = head.next;
//        }
//
//        if(head == null){
//            return null;
//        }
//
//        ListNode prev = head;
//        while(prev.next != null){
//            if(prev.next.val == val){
////                ListNode delNode = prev.next;
////                prev.next = delNode.next;
////                delNode.next = null;
//                prev.next = prev.next.next;
//            }else{
//                prev = prev.next;
//            }
//        }
//        return head;
//    }

        /**
         * use dummy head to solve this question
         */
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//
//        ListNode prev = dummyHead;
//        while (prev.next != null) {
//            if (prev.next.val == val) {
//                prev.next = prev.next.next;
//            } else {
//                prev = prev.next;
//            }
//        }
//        return dummyHead.next;

        if(head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Leetcode_203()).removeElements(head, 6);
        System.out.println(res);
    }
}
