class increasingBST {
    TreeNode node = null;
    public void rearrange(TreeNode root){
        if (root!=null){
            rearrange(root.left);
            root.left = null;
            node.right = root;
            node = root;
            rearrange(root.right);
        }
    }


    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        node = ans;
        rearrange(root);
        return ans.right;
    }
}