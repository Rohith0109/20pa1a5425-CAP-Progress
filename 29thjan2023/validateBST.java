class validateBST {
    ArrayList<Integer> ls = new ArrayList<>();
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        if (root==null)
        return true;

        isValidBST(root.left);
        int data = root.val;
        if (ls.size()==0)
        ls.add(data);
        else{
            if (ls.get(ls.size()-1)<data)
            ls.add(data);
            else
            flag = false;
        }
        isValidBST(root.right);

        return flag;
    }
}
