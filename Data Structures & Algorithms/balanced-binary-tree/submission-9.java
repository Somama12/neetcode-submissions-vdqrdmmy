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
        if(root == null) return true;
        boolean[] res = {true};

        findBalanced(root, res);
        return res[0];
    }

    public int findBalanced(TreeNode root, boolean[] res){
        if(root == null) return 0;

        int left = findBalanced(root.left, res);
        int right = findBalanced(root.right, res);
        if(Math.abs(left - right) > 1){
            res[0] = false;
        }
        return Math.max(left, right) +1;
    }
}
