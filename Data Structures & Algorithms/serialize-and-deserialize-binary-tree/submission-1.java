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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();

        preOrder(root, str);
        String data = str.toString();
        return data; 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] i = {0};
        TreeNode node = dfs(arr, i);
        return node;
    }

    public TreeNode dfs(String[] arr, int[] i){
        if(arr[i[0]].equals("#")){
            i[0]++;
            return null;
        }
        int val = Integer.parseInt(arr[i[0]++]);
        TreeNode root = new TreeNode(val);
        root.left = dfs(arr, i);
        root.right = dfs(arr, i);
        return root;
    }

    //preOrder traversal
    public void preOrder(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("#").append(",");
            return;
        }
        str.append(root.val).append(",");
        preOrder(root.left, str);
        preOrder(root.right, str);
    }
}
