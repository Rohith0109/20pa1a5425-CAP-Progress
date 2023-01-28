class convertBST {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if (root==null)
        return null;

        convertBST(root.right);
        root.val = sum+root.val;
        sum = root.val;
        convertBST(root.left);
        
        return root;
    }
}
