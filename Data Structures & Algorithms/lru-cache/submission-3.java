class LRUCache {
    public class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }
    Map<Integer,  Node> map;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        delete(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            delete(node);
            insert(node);
        }else{
            if( map.size()==cap){
                Node node = tail.prev;
                map.remove(node.key);
                delete(node);
            }
            Node newNode = new Node(key, value);
            insert(newNode);
            map.put(key, newNode);
        }
    }

    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        Node temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
}
