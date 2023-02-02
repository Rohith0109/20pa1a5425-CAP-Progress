public class Codec {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root==null)
        return "";
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()){
            TreeNode curr = que.poll();
            
            if (curr!=null){
                sb.append(curr.val+" ");
                que.offer(curr.left);
                que.offer(curr.right);
            }
            else{
                sb.append("# ");
            }
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0)
        return null;

        String [] arr = data.split(" ");
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        que.add(root);
        int i=0;
        while (!que.isEmpty()){
            TreeNode curr = que.poll();
            int left = 2*i+1;
            int right = 2*i+2;
            if (left<arr.length){
                if (!arr[left].equals("#")){
                    TreeNode temp = new TreeNode(Integer.parseInt(arr[left]));
                    curr.left = temp;
                    que.add(curr.left);
                }
                else{
                    curr.left = null;
                }
            }
            if (right<arr.length){
                if (!arr[right].equals("#")){
                    TreeNode temp = new TreeNode(Integer.parseInt(arr[right]));
                    curr.right = temp;
                    que.add(curr.right);
                }
                else{
                    curr.right = null;
                }
            }
            i++;
        }
        return root;

    }
}
