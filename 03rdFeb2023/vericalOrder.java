 class pair{
     TreeNode node;
     int off;
     int lev;
     pair(TreeNode node, int off, int lev){
         this.node = node;
         this.off = off;
         this.lev = lev;
     }
 }
class vericalOrder {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<List<Integer>> ls = new ArrayList<>();
        if (root==null)
        return ls;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<pair> que = new LinkedList<pair>();
        que.offer(new pair(root, 0, 0));
        while (!que.isEmpty()){
            pair curr = que.poll();
            TreeNode temp = curr.node;
            int offset = curr.off;
            int level = curr.lev;
            if (!map.containsKey(offset)){
                map.put(offset, new TreeMap<>());
            }
            TreeMap<Integer, PriorityQueue<Integer>> tm = map.get(offset);
            if (!tm.containsKey(level)){
                tm.put(level, new PriorityQueue<>());
            }
            PriorityQueue<Integer> pq = tm.get(level);
            pq.add(temp.val);
            if (temp.left!=null){
                que.offer(new pair(temp.left, offset-1, level+1));
            }
            if (temp.right!=null){
                que.offer(new pair(temp.right, offset+1, level+1));
            }
        }
        for(Map.Entry<Integer, TreeMap<Integer,PriorityQueue<Integer>>> entry: map.entrySet()){
            ArrayList<Integer> al = new ArrayList<>();
            TreeMap<Integer, PriorityQueue<Integer>> map1 = entry.getValue();
            for (Map.Entry<Integer, PriorityQueue<Integer>> ent: map1.entrySet()){
                PriorityQueue<Integer> que2 = ent.getValue();
                while (!que2.isEmpty()){
                    al.add(que2.poll());
                }
            }
            ls.add(al);
        }
        return ls;

    }
}
