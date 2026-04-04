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
        int count = 0;
        ListNode current = head;
        while(current!=null){
            current = current.next;
            count ++;
        }

        if(n==count){
            return head.next;
        }

        ListNode prevN = head;
        for(int i=1; i < (count - n);i++){
            prevN = prevN.next;
        }

        prevN.next = prevN.next.next;
        return head;
    }
}
