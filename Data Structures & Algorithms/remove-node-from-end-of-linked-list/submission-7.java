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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=1;
        ListNode current=head;
        while(current.next!=null){
            current=current.next;
            size++;
        }
        if(size==n){
            head=head.next;
            return head;
        }
        ListNode prev=head;
        for(int i=1;i<=(size-n-1);i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return head;
    }
}
