class BinaryTreeZigzagOrder {

    boolean flag = true;
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> llist = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> lst = new ArrayList<>();
        if (root==null)
        return llist;
        que.add(root);
        que.add(null);
        while (!que.isEmpty()){
            TreeNode curr = que.poll();
            if (curr==null){
                llist.add(lst);
                lst = new ArrayList<>();
                if (que.isEmpty())
                break;
                else
                que.add(null);
            }
            else{
                lst.add(curr.val);
                if (curr.left!=null){
                    que.add(curr.left);
                }
                if (curr.right!=null){
                    que.add(curr.right);
                }
            }
        }
        for (List<Integer> i:llist){
            if (flag){
                flag = false;
            }
            else{
                Collections.reverse(i);
                flag = true;
            }
        }
        return llist;
    }
}
