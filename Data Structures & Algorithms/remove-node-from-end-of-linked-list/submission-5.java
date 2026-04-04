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
        int size=0;
        ListNode current=head;
        while(current!=null){
            size++;
            current=current.next;
        }
        
        ListNode current1=head;
        for(int i=1;i<(size-n);i++){
            current1=current1.next;
        }
        if(n==size){
            return head=head.next;
        }
        current1.next=current1.next.next;
        return head;

        
    }
}
