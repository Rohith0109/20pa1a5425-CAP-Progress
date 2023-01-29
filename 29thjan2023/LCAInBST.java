class LCAInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val<q.val)
        return lowestCommonAncestor(root, q, p);

        if (root==null)
        return null;

        if (root.val==p.val || root.val==q.val)
        return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left!=null && right!=null)
        return root;
        else if (left!=null)
        return left;
        return right;

    }
}
