/*
 * 968. Binary Tree Cameras
 * Use dfs and start by realizing all parents of leaf/unmonitored node(s) must be a camera.
 * parents of a camera are monitored. parents of monitored nodes are unmonitored.
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
    int cameras = 0;
    
    public int minCameraCover(TreeNode root) {
        byte result = dfs(root);
        if(result == 3) { // root node is unmonitored
            return cameras+1; //put camera on root
        }
        
        return cameras;
    }
    
    // 1 = camera
    // 2 = monitored
    // 3 = unmonitored
    public byte dfs(TreeNode node) {
        if(node.left == null && node.right == null)
            return 3; // leaf node so unmonitored, return result to parent
        else {
            byte l = -1; // left node is null
            byte r = -1; // right node is null
            if(node.left != null)
                l = dfs(node.left);
            if(node.right != null)
                r = dfs(node.right);
            
            if(l == 3 || r == 3) { // parent of unmonitored, add camera, return result to parent
                cameras++;
                return 1;
            } else if(l == 1 || r == 1) { // parent of camera, therefore monitored, return result
                return 2;
            } else if(l == 2 || r == 2) { // parent of monitored, therefore unmonitored, return result
                return 3;
            }
            
            return -1; // never used
        }
    }
}