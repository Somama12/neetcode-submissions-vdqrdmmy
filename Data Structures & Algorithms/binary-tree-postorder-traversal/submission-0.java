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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root!=null){
            postOrder(res,root);
        }
        return res;
    }
    public void postOrder(List<Integer> list, TreeNode root){
        if(root==null) return;
        postOrder(list,root.left);
        postOrder(list,root.right);
        list.add(root.val);
    }
}