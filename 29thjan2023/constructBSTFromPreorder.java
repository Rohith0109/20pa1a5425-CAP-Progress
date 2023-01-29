class constructBSTFromPreorder {
    int n = 0;
    public TreeNode construct(int [] preorder, int lb, int ub){
        if (n>=preorder.length)
        return null;
        if (preorder[n]<lb || preorder[n]>ub)
        return null;

        TreeNode temp = new TreeNode(preorder[n++]);
        temp.left = construct(preorder, lb, temp.val);
        temp.right = construct(preorder, temp.val, ub);

        return temp;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int lb = Integer.MIN_VALUE;
        int ub = Integer.MAX_VALUE;
        int ind = 0;
        return construct(preorder, lb, ub);
    }
}
