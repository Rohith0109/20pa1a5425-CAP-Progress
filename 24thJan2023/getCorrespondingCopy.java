class getCorrespondingCopy {
    TreeNode ans;
    public void inorder(TreeNode org, TreeNode clon, TreeNode tar){
        if (org!=null && clon !=null){
            
            getTargetCopy(org.left, clon.left, tar);
            getTargetCopy(org.right, clon.right, tar);
            if (org == tar){
                
                System.out.println(clon.val);
                ans = clon;
                return;
            }
        }
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        inorder(original, cloned, target);
        return ans;

    }
}