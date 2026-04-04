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
        return invert(root);
    }
    public TreeNode invert(TreeNode node){
        if(node==null) return null;
        if(node.left==null && node.right==null) return node;
        TreeNode temp1=node.left;
        TreeNode temp2=node.right;
        node.left=temp2;
        node.right=temp1;
        invert(node.left);
        invert(node.right);
        return node;
    }
}
