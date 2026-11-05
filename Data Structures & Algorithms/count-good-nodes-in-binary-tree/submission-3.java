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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
    
        int[] ans = {0};
        int curMax = root.val;
        count(root, curMax, ans);
        return ans[0];
    }

    public void count(TreeNode root, int curMax, int[] ans){
        if(root == null) return;
        if(root.val >= curMax){
            ans[0]+=1;
            curMax = root.val;
        }
        count(root.left, curMax, ans);
        count(root.right, curMax, ans);
    }
}
