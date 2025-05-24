"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""
from collections import deque
from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return
        
        clone = Node(node.val)
        vis = {node: clone}
        queue = deque([node])

        while queue:
            cur = queue.popleft()
            for nxt in cur.neighbors:
                if nxt not in vis:
                    vis[nxt] = Node(nxt.val)
                    queue.append(nxt)
                vis[cur].neighbors.append(vis[nxt])
        return clone
