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
    private int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put( inorder[i], i);
        }
        return dfs(preorder, map, 0, preorder.length-1);
    }
    public TreeNode dfs(int[] preorder,HashMap<Integer, Integer> map, int l, int r){
        if(l>r) return null;
        int rootval= preorder[index++];
        TreeNode root=new TreeNode(rootval);
        int mid=map.get(rootval);
        root.left=dfs(preorder, map,l, mid-1);
        root.right=dfs(preorder, map,mid+1, r);
        return root;
    }
}
