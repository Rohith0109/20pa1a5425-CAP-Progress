class pair{
    TreeNode node;
    int num;
    pair(TreeNode node, int num){
        this.node = node;
        this.num = num;
    }
}

class maximumWidth {
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null)
        return 0;

        int max = 0;
        Queue<pair> que = new LinkedList<>();
        que.offer(new pair(root, 0));
        while (!que.isEmpty()){
            int size = que.size();
            int min = que.peek().num;
            int first =0; int last = 0;
            for (int i=0;i<size;i++){
                TreeNode curr = que.peek().node;
                int id = que.peek().num-min;
                que.poll();
                if (i==0) first = id;
                if (i==size-1) last = id;
                if (curr.left!=null){
                    que.offer(new pair(curr.left, id*2+1));
                }
                if (curr.right!=null){
                    que.offer(new pair(curr.right, id*2+2));
                }
            }
            max = Math.max(max, last-first+1);
        }
        return max;
    }
}
