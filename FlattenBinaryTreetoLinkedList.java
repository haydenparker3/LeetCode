/*
 * 114. Flatten Binary Tree to Linked List
 */

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
class Solution {
    Stack<TreeNode> s = new Stack<>();
    
    public void flatten(TreeNode root) {
        dfs(root);
        
        TreeNode curr = null;
        TreeNode prev = null;
        
        if(!s.isEmpty()) {
            prev = s.pop();
        }
        
        while(!s.isEmpty()) {
            curr = prev;
            prev = s.pop();
            
            prev.right = curr;
            prev.left = null;
        }
    }
    
    public void dfs(TreeNode node) {
        if(node != null) {
            s.push(node);
            dfs(node.left);
            dfs(node.right);
        }
    }
}