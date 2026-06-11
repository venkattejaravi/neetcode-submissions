"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        
        if not head:
            return head

        curr = head

        while curr:
            curr.next = Node(curr.val, curr.next)
            curr = curr.next.next

        
        # copying random pointers
        curr = head
        while curr:
            if curr.random and curr.next:
                curr.next.random = curr.random.next
            if curr.next:
                curr = curr.next.next

        # Splitting the nodes
        orig_curr = head
        clone_head = head.next

        clone_curr = clone_head

        while orig_curr:
            if orig_curr.next:
                orig_curr.next = orig_curr.next.next

            if clone_curr.next:
                clone_curr.next = clone_curr.next.next

            orig_curr = orig_curr.next
            clone_curr = clone_curr.next

        return clone_head
















