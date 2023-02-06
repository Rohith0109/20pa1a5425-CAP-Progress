class pair{
    int row;
    int col;
    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Flood {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rLen = image.length;
        int cLen = image[0].length;
        int [][] visit = new int[rLen][cLen];
        for (int i=0;i<rLen;i++){
            for (int j=0;j<cLen;j++){
                visit[i][j] = image[i][j];
            }
        }
        bfs(image, visit, sr, sc, color);
        return visit;

    }

    public void bfs(int[][] image, int[][] visit, int sr, int sc, int color){
        visit[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        Queue<pair> que = new LinkedList<>();
        que.offer(new pair(sr, sc));
        while (!que.isEmpty()){
            pair curr = que.poll();
            int row = curr.row;
            int col = curr.col;
            int [] drow = {0,1,0,-1};
            int [] dcol = {1,0,-1,0};
            for (int i=0;i<4;i++){
                int r = row+drow[i];
                int c = col+dcol[i];
                if (r>=0 && r<m && c>=0 && c<n){
                    if (image[r][c]==image[sr][sc] && visit[r][c]!=color){
                        visit[r][c] = color;
                        que.offer(new pair(r,c));
                    }
                }
            }
        }
    }
    

}
