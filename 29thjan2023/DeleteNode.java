class DeleteNode {
    public int successor(TreeNode root){
        int n = root.val;
        while (root.left!=null){
            n = root.left.val;
            root = root.left;
        }
        return n;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return root;
        }
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }
        else if (key>root.val){
            root.right = deleteNode(root.right,key);
        }
        else{
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            root.val = successor(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
}
