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
        int length=0;
        ListNode current=head;
        while(current!=null){
            current=current.next;
            length++;
        }
        if(n==length){
            head=head.next;
            return head;
        }
        ListNode prev=head;
        for(int i=1;i<=(length-n-1);i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return head;
    }
}
