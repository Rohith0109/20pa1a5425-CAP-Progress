class recoverBST {
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if (root==null)
        return;

        inorder(root, ls);
        int first = 0;
        int second = 0;
        int prev = ls.get(0);

        for (int i=1;i<ls.size();i++){
            if (prev>ls.get(i) && first==0)
            first = prev;
            if (prev>ls.get(i)&&first!=0)
            second = ls.get(i);

            prev = ls.get(i);
        }
        update(root, first, second);

    }

    public void inorder(TreeNode root, ArrayList<Integer> ls){
        if (root == null)
        return;

        inorder(root.left, ls);
        ls.add(root.val);
        inorder(root.right, ls);

    }

    public void update(TreeNode root, int v1, int v2){
        if (root==null)
        return;

        update(root.left, v1, v2);
        if (root.val==v2)
        root.val = v1;
        else if (root.val==v1)
        root.val = v2;
        update(root.right, v1, v2);
    }
}
