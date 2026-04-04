class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int time=0;
        int row=grid.length;
        int col=grid[0].length;
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
                    int newRow=cell[0]+dr[0];
                    int newCol=cell[1]+dr[1];
                    if(newRow>=0 && newRow<row && newCol>=0 && newCol<col && grid[newRow][newCol]==1){
                        q.offer(new int[]{newRow,newCol});
                        grid[newRow][newCol]=2;
                        fresh--;
                    }
                }
            }
             time++;

            
        }
        return fresh==0?time:-1;


    }
}
