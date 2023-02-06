class pair{
    int row;
    int col;
    int time;
    pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

class rottingOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][] visit = new int[n][m];
        Queue<pair> que = new LinkedList<>();
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==2){
                    visit[i][j] = 2;
                    que.offer(new pair(i,j,0));
                }
            }
        }
        int tm = 0;
        int [] drow = {-1, 0, 1, 0};
        int [] dcol = {0, 1, 0, -1};
        while (!que.isEmpty()){
            pair curr = que.poll();
            int row = curr.row;
            int col = curr.col;
            int time = curr.time;
            tm = Math.max(time, tm);
            for (int i=0;i<4;i++){
                int r = row+drow[i];
                int c = col+dcol[i];
                if (r>=0 && r< n && c>=0 && c<m){
                    if (grid[r][c]==1 && visit[r][c]!=2){
                        visit[r][c] = 2;
                        que.offer(new pair(r,c,time+1));
                    }
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]==1 && visit[i][j]!=2)
                return -1;
            }
        }
        return tm;
    }
}
