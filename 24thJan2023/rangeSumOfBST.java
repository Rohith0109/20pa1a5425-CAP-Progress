class rangeSumOfBST {
    int sum = 0;
    int low,high;
    void preorder(TreeNode root){
        if (root!=null){
            if (root.val>=low && root.val<=high)
            sum += root.val;
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        preorder(root);
        return sum;
    }
}