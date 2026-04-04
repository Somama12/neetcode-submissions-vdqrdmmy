class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cell=q.poll();
                        for(int[] dr:directions){
                            int r=cell[0]+dr[0];
                            int c=cell[1]+dr[1];
                            if(r>=0 && c>=0 && r<row && c<col && grid[r][c]!=-1 && grid[r][c]>(grid[i][j]+1)){
                                if (grid[r][c] > grid[cell[0]][cell[1]] + 1) {
                        grid[r][c] = grid[cell[0]][cell[1]] + 1;
                        q.offer(new int[]{r, c});
                    }
                            }
                        }
                    }
                }
            }
        }
    }
}
