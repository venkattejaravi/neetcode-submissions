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
    public ListNode getKthNode(ListNode node, int k) {
        while(node != null && k > 0){
            node = node.next;
            k --;
        }
        return node;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode groupPrev = dummyHead;

        while(true) {
            ListNode kthNode = getKthNode(groupPrev, k);
            if(kthNode == null) break;
            ListNode groupNext = kthNode.next;

            // Reverse the nodes untill kthNode
            ListNode curr = groupPrev.next;
            ListNode prev = kthNode.next;

            while(curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // (0) -> (1) -> (0) -> (2) -> (1) -> (3) -> (4) 
            ListNode temp = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = temp;
        }
        return dummyHead.next;
    }
}
