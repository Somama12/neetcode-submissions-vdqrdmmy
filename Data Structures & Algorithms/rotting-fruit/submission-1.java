class Solution {
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int fresh=0;
        int time=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
        while(fresh>0 && !q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cell=q.poll();
                for(int[] dr:directions){
                    int r=cell[0]+dr[0];
                    int c=cell[1]+dr[1];
                    if(r>=0 && c>=0 && r<row && c<col && grid[r][c]==1){
                        grid[r][c]=2;
                        q.offer(new int[]{r,c});
                        fresh--;
                    }
                }
            }
             time++;
        }
        return fresh==0?time:-1;
    }
}
