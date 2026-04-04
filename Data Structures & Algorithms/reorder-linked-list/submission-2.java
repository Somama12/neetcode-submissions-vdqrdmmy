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
    public void reorderList(ListNode head) {
      if(head==null || head.next==null) return;

      ListNode fast=head;
      ListNode slow=head;
      while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
      }  
      ListNode prev=null;
      ListNode current=slow;
      while(current!=null){
        ListNode next=current.next;
        current.next=prev;
        prev=current;
        current=next;
      }
      ListNode left=head;
      ListNode right=prev;
      while(right!=null){
        ListNode leftNext=left.next;
        ListNode rightNext=right.next;

        left.next=right;
        right.next=leftNext;

        left=leftNext;
        right=rightNext;

        if(left==null){
            break;
        }
      }
      if(left!=null){
        left.next=null;
      }
    }
}
