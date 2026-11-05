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
        Map<Integer, Integer> map = new HashMap<>();
        index = 0;

        int left = 0;
        int right = preorder.length-1;

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return findTree(preorder, map, left, right);
    }

    public TreeNode findTree(int[] preorder, Map<Integer,Integer> map, int left, int right){
        if(left>right){
            return null;
        }
        int headVal = preorder[index++];
        TreeNode head = new TreeNode(headVal);
        int mid = map.get(headVal);

        head.left = findTree(preorder, map, left, mid-1);
        head.right =findTree(preorder, map, mid+1, right);

        return head;
    }
}
