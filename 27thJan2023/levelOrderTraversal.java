class levelOrderTraversal {
    List<List<Integer>> ls = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root==null)
        return ls;
        
        que.add(root);
        que.add(null);
        ArrayList<Integer> al = new ArrayList<>();
        while (!que.isEmpty()){
            TreeNode curr = que.poll();
            if (curr==null){
                ls.add(al);
                al = new ArrayList<>();
                if (que.isEmpty())
                break;
                else
                que.add(null);
            }
            else{
                al.add(curr.val);
                if (curr.left!=null){
                    que.offer(curr.left);
                }
                if (curr.right!=null){
                    que.offer(curr.right);
                }
            }
        }
        return ls;
    }
}
