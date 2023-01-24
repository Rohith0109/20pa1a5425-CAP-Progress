import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeInorder{
    ArrayList<Integer> al = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
        if (root==null)
        return al;
        inorderTraversal(root.left);
        al.add(root.val);
        inorderTraversal(root.right);

        return al;
    }

    
}


