class keysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean [] visit = new boolean[n];
        dfs(0, rooms, visit);

        for (int i=0;i<n;i++)
        if (!visit[i])
        return false;
        return true;
    }

    public void dfs(int i, List<List<Integer>> adj, boolean[] visit){
        visit[i] = true;
        for (int e: adj.get(i)){
            if (!visit[e]){
                visit[e] = true;
                dfs(e, adj, visit);
            }
        }

    }
}
