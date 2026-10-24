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
        //if the length of list is N, need to remove (N-n+1)th node
        //I would need to get to the (N-n)th node
        //so first I would need the length of the list, N
        //After the I can get the N-n th node and I can just do (N-n)th.next = (N-n)th.next.next

        if(head == null) return head;

        ListNode current = head;
        int N = 0;
        
        while(current!=null){
            current = current.next;
            N++;
        }

        if(N == n){
            return head.next;
        }

        ListNode prev = head;
        

        //if N = 4
        //N - n = 2

        for(int i=1; i<(N-n); i++){
            prev = prev.next;
        }

        prev.next = prev.next.next;
        return head;
    }
}
