class pair{
    int row;
    int col;
    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class noOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visit = new int[n];
        List<List<Integer>> ls = new ArrayList<>();
        for (int i=0;i<n;i++){
            ls.add(new ArrayList<Integer>());
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (isConnected[i][j]==1 && i!=j){
                    ls.get(i).add(j);
                    ls.get(j).add(i);
                }
            }
        }

        int count =0;
        for (int i=0;i<n;i++){
            if (visit[i]==0){
                count++;
                dfs(i, ls, visit);
            }
        }
        return count;
    }

    public void dfs(int source, List<List<Integer>> ls, int [] visit){
       visit[source] = 1;
       for (int e: ls.get(source)){
           if (visit[e]==0){
               dfs(e, ls, visit);
           }
       }
    }
}
