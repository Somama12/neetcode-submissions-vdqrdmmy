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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        if(root.left==null && root.right==null) return root;
        TreeNode temp1=root.left;
        TreeNode temp2=root.right;
        root.left=temp2;
        root.right=temp1;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
