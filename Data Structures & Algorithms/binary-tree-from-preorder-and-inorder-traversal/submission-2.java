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
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return dfs(map, preorder, 0, preorder.length-1);
    }

    public TreeNode dfs(Map<Integer,Integer> map, int[] preoder, int left, int right){
        if(left>right) return null;
        int nodeVal = preoder[index++];
        TreeNode root = new TreeNode(nodeVal);
        int mid = map.get(nodeVal);
        root.left = dfs(map, preoder, left, mid-1);
        root.right = dfs(map, preoder, mid+1, right);
        return root;
    }
}
