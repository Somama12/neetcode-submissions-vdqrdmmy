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
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node==null){
                sb.append("#,");
            }else{
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] value=data.split(",");
        if(data.isEmpty()) return null;
        TreeNode root=new TreeNode(Integer.parseInt(value[0]));
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(!value[i].equals("#")){
                TreeNode left=new TreeNode(Integer.parseInt(value[i]));
                node.left=left;
                q.offer(left);
            }
            i++;
            if(!value[i].equals("#")){
                TreeNode right=new TreeNode(Integer.parseInt(value[i]));
                node.right=right;
                q.offer(right);
            }
            i++;
        }
        return root;
    }
}
