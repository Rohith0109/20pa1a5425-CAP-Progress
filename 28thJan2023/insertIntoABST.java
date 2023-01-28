class insertIntoABST{
  public TreeNode insertIntoBST(TreeNode root,val){
    TreeNode temp = new TreeNode(0);
    if (root==null)
      return temp;
    
    if (val<root.val){
      if (root.left==null){
        root.left = temp;
      }
      insertIntoBST(root.left, val);
    }
    if (val>root.val){
      if (root.right == null){
        root.right = temp;
      }
      insertIntoBST(root.right, val);
    }
    return root;
}
