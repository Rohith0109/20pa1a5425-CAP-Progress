class pair{
    int row;
    int col;
    int dist;
    pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class shortestPath {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visit = new boolean[m][n];
        if (grid[0][0]!=0 || grid[m-1][n-1]!=0)
        return -1;
        return bfs(grid, visit, 0, 0);

    }

    public int bfs(int[][] grid, boolean[][] visit, int rw, int cl){
        int m = grid.length;
        int n = grid[0].length;
        Queue<pair> que = new LinkedList<>();
        que.offer(new pair(rw, cl, 1));
        visit[rw][cl] = true;
        while (!que.isEmpty()){
            pair curr = que.poll();
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;
            if (row==m-1 && col==n-1)
            return dist;
            for (int i=-1;i<=1;i++){
                for (int j=-1;j<=1;j++){
                    int r = row + i;
                    int c = col + j;
                    if (r>=0 && r<m && c>=0 && c<n){
                        if (!visit[r][c] && grid[r][c]==0){
                            visit[r][c] = true;
                            que.offer(new pair(r, c, dist+1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
