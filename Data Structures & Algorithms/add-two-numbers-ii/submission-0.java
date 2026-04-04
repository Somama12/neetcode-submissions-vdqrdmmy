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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverse(l1);
        l2=reverse(l2);
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;

        while(l1!=null || l2!=null || carry>0){
            int num1 = l1!=null? l1.val:0;
            int num2 = l2!=null ? l2.val:0;
            int sum = num1 + num2 + carry;

            current.next = new ListNode(sum % 10);
            current=current.next;
            carry = sum/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return reverse(dummy.next);
    }

   public ListNode reverse(ListNode head){
    ListNode prev = null;
    ListNode current = head;
    while(current != null){
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    return prev; // return the new head
}

}