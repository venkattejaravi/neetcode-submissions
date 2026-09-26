class Node:
        def __init__(self, key = None, val = None):
            self.prev = None
            self.next = None
            self.key = key
            self.val = val

class LRUCache:
    

    def __init__(self, capacity: int):
        self.key_to_node = defaultdict(Node)
        self.capacity = capacity
        self.head, self.tail = Node(), Node()
        self.head.next, self.tail.prev = self.tail, self.head

    def get(self, key: int) -> int:
        if not key in self.key_to_node:
            return -1
        else:
            target_node = self.key_to_node.get(key)
            self.move_to_front(target_node)
            return target_node.val 


    def put(self, key: int, value: int) -> None:
        if not key in self.key_to_node:
            new_node = Node(key, value)
            self.key_to_node[key] = new_node
            
            new_node.next, new_node.prev = self.head.next, self.head
            self.head.next = new_node
            new_node.next.prev = new_node
                
            if len(self.key_to_node) > self.capacity:
                self.remove()
                
        else:
            target_node = self.key_to_node.get(key)
            target_node.val = value
            self.move_to_front(target_node)

    def move_to_front(self, node):		
        node.prev.next = node.next
        node.next.prev = node.prev			
        head_node = self.head
        head_node.next.prev = node
        node.next = head_node.next
        node.prev = head_node
        head_node.next = node

    def remove(self):
        stale_node = self.tail.prev
        stale_node.prev.next = self.tail
        self.tail.prev = stale_node.prev
        del self.key_to_node[stale_node.key]

