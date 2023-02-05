lass pair{
     TreeNode node;
     int lev;
     pair(TreeNode node, int lev){
         this.node = node;
         this.lev = lev;
     }
 }
class allNodeDistanceK {

    public void dfs(TreeNode root, HashMap<TreeNode, TreeNode> map){
        if (root==null)
        return;

        if (root.left!=null){
            map.put(root.left, root);
            dfs(root.left, map);
        }
        if (root.right!=null){
            map.put(root.right, root);
            dfs(root.right, map);
        }
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> ls = new ArrayList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, map);
        HashSet<TreeNode> hs = new HashSet<>();
        Queue<pair> que = new LinkedList<>();
        que.offer(new pair(target, 0));
        hs.add(target);
        while (!que.isEmpty()){
            pair temp = que.poll();
            TreeNode curr = temp.node;
            int lev = temp.lev;
            if (lev==k){
                ls.add(curr.val);
            }
            if (lev>k){
                break;
            }
            if (curr.left!=null && hs.add(curr.left)){
                que.offer(new pair(curr.left, lev+1));
                hs.add(curr.left);
            }
            if (curr.right!=null && hs.add(curr.right)){
                que.offer(new pair(curr.right, lev+1));
                hs.add(curr.right);
            }
            if (map.containsKey(curr) && hs.add(map.get(curr))){
                que.offer(new pair(map.get(curr), lev+1));
                hs.add(map.get(curr));
            }
        }
        return ls;
    }
}
