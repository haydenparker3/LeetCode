/*
 * 236. Lowest Common Ancestor of a Binary Tree
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ret;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        
        return ret;
    }
    
    public boolean find(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return false;
        } else {
            if(node == p || node == q) {
                boolean fl = find(node.left, p, q);
                boolean fr = find(node.right, p, q);
                
                if(fl || fr) {
                    ret = node;
                    return false;
                } else {
                    return true;
                }
            } else {
                boolean fl = find(node.left, p, q);
                boolean fr = find(node.right, p, q);
                
                if(fl && fr) {
                    ret = node;
                    return false;
                } else if(fl || fr) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}