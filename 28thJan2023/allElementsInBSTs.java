class allElementsInBSTs{
  ArrayList<Integer> ls = new ArrayList<>();
    public List<Integer> inorder(TreeNode root){
        if (root==null)
        return new ArrayList<>();

        inorder(root.left);
        ls.add(root.val);
        inorder(root.right);
        return ls;
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1);
        inorder(root2);
        Collections.sort(ls);
        return ls;
    }
}
