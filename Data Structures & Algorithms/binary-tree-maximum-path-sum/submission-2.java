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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        recursion(root);
        return maxSum;
    }

    public int recursion(TreeNode root){
        if(root==null) return 0;
        int left=Math.max(0,recursion(root.left));
        int right=Math.max(0,recursion(root.right));

        maxSum = Math.max(maxSum, left + right + root.val);

        return Math.max(left, right)+root.val;
    }
}
