class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder strRoot = new StringBuilder();
        StringBuilder strSubRoot = new StringBuilder();

        preorder(root, strRoot);
        preorder(subRoot, strSubRoot);

        return strRoot.toString().contains(strSubRoot.toString());
    }

    public void preorder(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append(",#");
            return;
        }

        str.append(",").append(root.val);

        preorder(root.left, str);
        preorder(root.right, str);
    }
}