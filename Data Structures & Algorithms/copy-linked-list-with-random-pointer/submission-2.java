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
        if(head == null) return null;
        // Insert clone nodes into original list
        Node curr = head;
        while(curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Add random pointers
        curr = head;
        while(curr != null){
            curr.next.random = (curr.random != null)?curr.random.next:null;
            curr = curr.next.next;
        }

        // seperate the cloned nodes
        curr = head;
        Node clonehead = curr.next;
        while(curr != null) {
            Node clone = curr.next;
            curr.next = clone.next;
            clone.next = (clone.next != null)?clone.next.next:null;
            curr = curr.next;
        }
        return clonehead;
    }






}
