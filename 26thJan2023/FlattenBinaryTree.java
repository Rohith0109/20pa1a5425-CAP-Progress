class FlatternBinaryTree {
   
    TreeNode curr = null;
    public void intoTree(ArrayList<TreeNode> al){
        if (al.size()==0)
        return;

        TreeNode dummy = al.get(0);
        curr = dummy;
        TreeNode temp = curr;
        for (int i=1;i<al.size();i++){
            dummy = al.get(i);
            temp.right = dummy;
            temp.left = null;
            temp = dummy;
        }

    }

    ArrayList<TreeNode> ls = new ArrayList<>();
    public ArrayList<TreeNode> preorder (TreeNode root){
        if (root!=null){
            ls.add(root);
            preorder(root.left);
            preorder(root.right);
        }
        return ls;
    }

    public void flatten(TreeNode root) {
        preorder(root);
        intoTree(ls);
        root = curr;
    }
}
