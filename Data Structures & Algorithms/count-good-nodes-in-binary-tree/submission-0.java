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
        if(root==null) return 0;
        int[] ans={0};
        count(root, ans, root.val);
        return ans[0];
    }
    public void count(TreeNode root, int[] ans, int val){
        if(root==null) return;
        if(root.val>=val){
            ans[0]+=1;
        }
        count(root.left, ans, root.val>val?root.val:val);
        count(root.right, ans, root.val>val?root.val:val);
    }
}
