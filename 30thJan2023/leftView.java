public class leftView 
{
    
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList <Integer> ls = new ArrayList<>();
        if (root==null)
        return ls;

        Queue <TreeNode> que = new LinkedList<>();

        que.add(root);
        while (!que.isEmpty()){
            int size = que.size();
            for (int i=0;i<size;i++){
                TreeNode curr = que.poll();

                if (i==0)
                ls.add(curr.data);

                if (curr.left!=null)
                que.offer(curr.left);

                if (curr.right!=null)
                que.offer(curr.right);
            }
        }
        return ls;
    }
}
