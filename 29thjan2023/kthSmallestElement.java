class kthSmallestElement {
    ArrayList<Integer> ls = new ArrayList<>();
    public void preorder(TreeNode root){
        if (root==null)
        return;

        preorder(root.left);
        ls.add(root.val);
        preorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        preorder(root);
        return ls.get(k-1);

    }
}
