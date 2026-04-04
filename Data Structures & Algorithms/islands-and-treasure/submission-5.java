class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int INF=2147483647;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] node=q.poll();
            for(int[] dr : directions){
                int r=node[0]+dr[0];
                int c=node[1]+dr[1];

                if(r>=0 && c>=0 && r<row && c<col && grid[r][c]==INF){
                    grid[r][c]=grid[node[0]][node[1]]+1;
                    q.offer(new int[]{r,c});
                }
            }
        }
    }
}
