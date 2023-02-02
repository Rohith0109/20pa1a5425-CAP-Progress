class topViewOfBinaryTree{
  	public static void topView(Node root) {
      for (Integer i: verticalOrder(root))
          System.out.print(i+" ");
      
    }

    public static List<Integer> verticalOrder(Node root){
        ArrayList<Integer> ls = new ArrayList<>();
        if (root==null)
            return ls;
        
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        HashMap<Node, Integer> indMap = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        indMap.put(root,0);
        while (!que.isEmpty()){
            Node curr = que.poll();
            int col = indMap.get(curr);
            if (!map.containsKey(col))
                map.put(col, new ArrayList<Integer>());
            map.get(col).add(curr.data);
            if (curr.left!=null){
                que.offer(curr.left);
                indMap.put(curr.left, col-1);
            }
            if (curr.right!=null){
                que.offer(curr.right);
                indMap.put(curr.right, col+1);
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (Map.Entry<Integer,ArrayList<Integer>> entry: map.entrySet()){
            al.add(entry.getValue().get(0));
        }
        return al;
    }
