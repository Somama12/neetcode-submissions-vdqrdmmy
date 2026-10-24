/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        map.put(null, null);

        Node current = head;
        
        while(current!=null){
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;
        while(current!=null){
            Node result = map.get(current);
            result.next = map.get(current.next);
            result.random = map.get(current.random);

            current = current.next;
        }

        return map.get(head);
    }
}
