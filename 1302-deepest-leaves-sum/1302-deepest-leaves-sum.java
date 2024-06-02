/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 import java.util.*;

class Solution {
    static class Node {
        TreeNode tn;
        int depth;
        Node(TreeNode tn, int depth) {
            this.tn = tn;
            this.depth = depth;
        }
    }
    public int deepestLeavesSum(TreeNode root) {
        int depth = 0;
        ArrayList<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.tn.left == null && cur.tn.right == null && cur.depth == depth) {
                list.add(cur);
                continue;
            }
            if(cur.tn.left != null) {
                if(cur.depth + 1 > depth) {
                    list = new ArrayList<>();
                    depth = cur.depth + 1;
                }
                queue.add(new Node(cur.tn.left, cur.depth + 1));
            }
            if(cur.tn.right != null) {
                if(cur.depth + 1 > depth) {
                    list = new ArrayList<>();
                    depth = cur.depth + 1;
                }
                queue.add(new Node(cur.tn.right, cur.depth + 1));
            }
        }
        int result = 0;
        for(Node i : list) {
            result += i.tn.val;
        }
        return result;
    }
}