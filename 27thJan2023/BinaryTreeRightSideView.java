class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if (root==null)
        return ls;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            int size = que.size();
            for (int i=0;i<size;i++){
                TreeNode curr = que.poll();
                if (i==0){
                    ls.add(curr.val);
                }
                if (curr.right!=null){
                    que.offer(curr.right);
                }
                if (curr.left!=null){
                    que.offer(curr.left);
                }
            }
        }
        return ls;
    }
}
