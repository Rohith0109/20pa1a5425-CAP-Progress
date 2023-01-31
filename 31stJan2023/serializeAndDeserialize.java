public class serializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root==null)
        return "";

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            for (int i=0;i<size;i++){
                TreeNode curr = que.poll();
                if (curr==null){
                    sb.append("# ");
                    continue;
                }
                sb.append(curr.val+" ");
                que.offer(curr.left);
                que.offer(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0)
        return null;

        String [] arr = data.split(" ");
        
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        for (int i=1;i<arr.length;i++){
            System.out.println(arr[i]);
            TreeNode temp = que.poll();
            if (!arr[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                temp.left = left;
                que.add(left);
            }
            if (!arr[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                temp.right = right;
                que.add(right);
            }
        }
        return root;
    }
}
