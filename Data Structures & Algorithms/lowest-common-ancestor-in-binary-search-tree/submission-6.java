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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q) return root;

        TreeNode current = root;

        while(current!=null){
            if(current.val < p.val && current.val < q.val){
                current = current.right;
            }else if(current == p && current == q){
                return current;
            }else if(current.val > p.val && current.val > q.val){
                current = current.left;
            }else{
                return current;
            }
        }
        return current;
    }
}
