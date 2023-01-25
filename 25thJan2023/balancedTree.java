class balancedTree {

    boolean flag = true;
    public int height(TreeNode root){
        if (root==null)
        return 0;

        int left = height(root.left);
        int right = height(root.right);
        if (flag){    
            if (Math.abs(left-right)>1)
            flag = false;
            else
            flag = true;
            }
        return (Math.max(left, right)+1);
    }

    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
        

    }
}
