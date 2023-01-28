class findModeInBST {
    HashMap<Integer,Integer> hm = new HashMap<>();
    public void frequency(TreeNode root){
        if (root==null){
            return;
        }
        frequency(root.left);
        hm.merge(root.val, 1, Integer::sum);
        frequency(root.right);
    }

    public void printHashMap(HashMap<Integer,Integer> mp){
        for (Map.Entry<Integer,Integer> entry: mp.entrySet())
        System.out.println(entry.getKey()+" "+entry.getValue());
        
    }

    public int[] findMode(TreeNode root) {
        frequency(root);
        printHashMap(hm);
        int [] arr = new int[0];
        if (root==null){
            return arr;
        }
        int max=0;
        int count = 0;
        for (Map.Entry<Integer,Integer> entry: hm.entrySet()){
            if (entry.getValue()>max){
                max = entry.getValue();
                count =0;
            }
            if (entry.getValue()==max){
                count += 1;
            }
        }
        System.out.println(count);
        arr = new int[count];
        int i=0;
        for (Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if (entry.getValue()==max){
                arr[i++] = entry.getKey();
            }
        }
        return arr;
    }
}
