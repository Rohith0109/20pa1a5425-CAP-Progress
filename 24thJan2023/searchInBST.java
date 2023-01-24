class searchInBST {
    TreeNode res = null;
    public TreeNode searchBST(TreeNode root, int val) {
        if (root!=null)
        {
            if (val<root.val){
                searchBST(root.left, val);
            }
            else if (val>root.val){
                searchBST(root.right, val);
            }
            else
            res = root;
            
        }
        return res;
    }
}