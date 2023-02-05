class binaryTreeMaxSum {
    private int max_sum;
    public int maxSum(TreeNode root){
        if (root==null)
        return 0;

        int left = Math.max(maxSum(root.left),0);
        int right = Math.max(maxSum(root.right),0);
        max_sum = Math.max(max_sum, left+right+root.val);

        return Math.max(left+root.val, right+root.val);
    }
    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        maxSum(root);
        return max_sum;

    }
}
