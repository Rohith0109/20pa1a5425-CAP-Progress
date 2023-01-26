class FlatternBinaryTree {
    TreeNode curr = null;
    public void flatten(TreeNode root) {
        if (root==null)
        return;
        
        flatten(root.right);
        flatten(root.left);
        root.right = curr;
        root.left = null;
        curr = root;
        
    }
}
