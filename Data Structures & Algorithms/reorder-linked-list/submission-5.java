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
        if(head == null || head.next == null) return;

        //find mid
        //From the mid to the end, reverse the linkedlist
        //now merge the two linkedList alternatively

        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }

        ListNode firstHalf = head;
        slow.next = null;
        ListNode secondHalf = prev;

        while(firstHalf!=null && secondHalf!=null){
            ListNode nextFirst = firstHalf.next;
            ListNode nextSecond = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = nextFirst;

            firstHalf = nextFirst;
            secondHalf = secondHalf.next;

            firstHalf = nextFirst;
            secondHalf = nextSecond;
        }

    }
}
