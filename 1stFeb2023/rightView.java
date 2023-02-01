class rightView {
    ArrayList<Integer> al = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        rightView(root, 1, new int[]{0});

        return al;
    }
    public void rightView(TreeNode root, int level, int []max){
        if (root==null)
        return;

        if (max[0]<level){
            al.add(root.val);
            max[0]++;
        }
        
        rightView(root.right, level+1, max);
        rightView(root.left, level+1, max);
    }
}
