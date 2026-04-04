/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;

        return divide(lists, 0 , lists.length - 1);
    }
    public ListNode divide(ListNode[] lists, int left, int right){
        if(left > right) return null;
        if(left == right) return lists[left];

        int mid = left + (right-left)/2;
        ListNode leftSide = divide(lists, left , mid);
        ListNode rightSide = divide(lists, mid+1, right);
        return merge(leftSide, rightSide);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(left!=null && right!=null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if(left!=null){
            current.next=left;
        }
        if(right!=null){
            current.next = right;
        }
        return dummy.next;
    }
}
