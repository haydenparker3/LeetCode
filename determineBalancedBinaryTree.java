/*
 * 110. Balanced Binary Tree
 * determin if the binary tree is balanced. If the max depth of the left and right nodes
 * differ by more than 1 then the tree is not balanced. Stops further recursive calls by returning
 * a depth of -1 which is impossible signaling previous recursive calls to halt
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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int balanced = height(root, 0);
        if(balanced == -1)
            return false;
        else
            return true;
    }
    
    public int height(TreeNode node, int depth) {
        if(node == null)
            return depth-1;
        
        int depthL = height(node.left, depth+1);
        if(depthL == -1)
            return -1;
        int depthR = height(node.right, depth+1);
        if(depthR == -1)
            return -1;
        
        if(Math.abs(depthL - depthR) > 1) // tree is imbalanced returns -1 to signal to halt recursive calls
            return -1;
        
        return Math.max(depthL, depthR);
        
    }
}