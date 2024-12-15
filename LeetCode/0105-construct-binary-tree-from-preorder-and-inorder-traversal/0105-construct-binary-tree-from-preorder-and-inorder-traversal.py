# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        indices = {val:idx for idx, val in enumerate(inorder)}
        pre_iter = iter(preorder)
        
        def dfs(start, end):
            if start > end:
                return None
            
            val = next(pre_iter)
            mid = indices[val]
            
            left = dfs(start, mid - 1)
            right = dfs(mid + 1, end)
            return TreeNode(val, left, right)
        
        return dfs(0, len(inorder) - 1)