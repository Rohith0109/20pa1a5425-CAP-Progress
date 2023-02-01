class leftView {
    ArrayList<Integer> al = new ArrayList<>();
    public List<Integer> leftSideView(TreeNode root) {
        left(root, 1, new int[]{0});

        return al;
    }
    public void left(TreeNode root, int level, int []max){
        if (root==null)
        return;

        if (max[0]<level){
            al.add(root.val);
            max[0]++;
        }
        
        left(root.right, level+1, max);
        left(root.left, level+1, max);
    }
}
