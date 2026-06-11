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
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);

        Node curr = head;

        while(curr != null) {
            oldToCopy.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            oldToCopy.get(curr).next = oldToCopy.get(curr.next);
            oldToCopy.get(curr).random = oldToCopy.get(curr.random);
            curr = curr.next;
        }
        return oldToCopy.get(head);
    }
}
