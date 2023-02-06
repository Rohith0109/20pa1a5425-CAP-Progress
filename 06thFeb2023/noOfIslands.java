class pair{
    int row;
    int col;
    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class noOfIslands {
    public void bfs(int rw, int cl, int [][] visit, char [][] grid){
        visit[rw][cl] = 1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> que = new LinkedList<>();
        que.offer(new pair(rw, cl));
        while (!que.isEmpty()){
            pair curr = que.poll();
            int row = curr.row;
            int col = curr.col;
            int [] drow = {0, 1, 0, -1};
            int [] dcol = {1, 0, -1, 0};
            for (int i=0;i<4;i++){
                int r = row+drow[i];
                int c = col+dcol[i];
                if (r>=0 && r<n && c>=0 && c<m){
                    if (grid[r][c]=='1' && visit[r][c]!=1){
                        visit[r][c] = 1;
                        que.offer(new pair(r, c));
                    }
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visit = new int[n][m];
        int count = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]=='1' && visit[i][j]!=1){
                    count++;
                    bfs(i, j, visit, grid);
                }
            }
        }
        return count;
    }
}
