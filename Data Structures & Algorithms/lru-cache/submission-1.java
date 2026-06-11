class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public Node(int key, int val, Node prev, Node next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    private Map<Integer, Node> cache;
    private Node left;
    private Node right;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;        
    }

    public void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insert(Node node) {
        Node prevNodeOfRight = right.prev;
        prevNodeOfRight.next = node;
        node.prev = prevNodeOfRight;
        node.next = right;
        right.prev = node;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;

    }
    
    public void put(int key, int value) {
        Node node;
        if(cache.containsKey(key)){
            node = cache.get(key);
            remove(node);
            cache.remove(key);
        }
        node = new Node(key, value);
        insert(node);
        cache.put(key, node);

        if(cache.size() > capacity) {
            cache.remove(left.next.key);
            remove(left.next);
        }
    }
}
