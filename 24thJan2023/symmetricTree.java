public class SymmetricTree {
    
    boolean flag = true;
    public void isEqual(TreeNode node1, TreeNode node2){
        if (node1!=null && node2!=null){
            isEqual(node1.left, node2.right);
            if (node1.val!=node2.val){
                flag = false;
                return;
            }
            isEqual(node1.right, node2.left);
        }
        else if (node1==null && node2==null){

        }
        else
        flag = false;

    }


    public boolean isSymmetric(TreeNode root) {
        isEqual(root.left, root.right);
        return flag;
    }

}
