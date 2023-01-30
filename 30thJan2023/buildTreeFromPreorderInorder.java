class buildTreeFromPreorderInorder {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(0, 0, inorder.length-1, preorder, inorder);
    }

    public TreeNode construct(int preS, int inS, int inE, int [] preorder, int[] inorder){
        if (preS>preorder.length-1 || inS>inE)
        return null;

        TreeNode root = new TreeNode(preorder[preS]);

        int indx = 0;
        for (int i=0;i<inorder.length;i++){
            if (inorder[i] == root.val)
            indx = i;
        }

        root.left = construct(preS+1, inS, indx-1, preorder, inorder);
        root.right = construct(preS+indx-inS+1, indx+1, inE, preorder, inorder);

        return root;
    }
}
