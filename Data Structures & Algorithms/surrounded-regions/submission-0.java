class Solution {
    public void solve(char[][] board) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<col;i++){
            if(board[0][i]=='O') bfs(0, i, board);
            if(board[row-1][i]=='O') bfs(row-1, i, board);     
        }
        for(int i=0;i<row;i++){
            if(board[i][0]=='O') bfs(i, 0, board);
            if(board[i][col-1]=='O') bfs(i, col-1, board);     
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='S'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void bfs(int i, int j, char[][] board){
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i, j});
        board[i][j]='S';
        while(!q.isEmpty()){
            int[] cell=q.poll();
            for(int[] dr:directions){
                int r=cell[0]+dr[0];
                int c=cell[1]+dr[1];
                if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c]=='O'){
                    board[r][c]='S';
                    q.offer(new int[]{r,c});
                }
            }
        }
    }
}
