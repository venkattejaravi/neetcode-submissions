# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        slow, fast = head, head.next

        while fast and fast.next:
            slow, fast = slow.next, fast.next.next
        
        

        # Reverse the second half
        second = slow.next
        slow.next = None
        prev = None

        while second:
            temp = second.next
            second.next = prev
            prev = second
            second = temp

        first, second = head, prev
        # Merge two lists
        while second:
            temp1, temp2 = first.next, second.next
            first.next = second
            second.next = temp1
            first, second = temp1, temp2








