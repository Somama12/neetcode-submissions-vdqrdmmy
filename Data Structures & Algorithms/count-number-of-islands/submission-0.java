class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int row=grid.length;
        int col=grid[0].length;
        int island=0;
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    island++;
                    Queue<int[]> q=new LinkedList<>();
                    q.offer(new int[]{i,j});
                    grid[i][j]='0';
                    while(!q.isEmpty()){
                        int[] cell=q.poll();
                        for(int[] dir:directions){
                            int newRow=cell[0]+dir[0];
                            int newCol=cell[1]+dir[1];
                            if(newRow>=0 && newCol>=0 && newRow<row && newCol<col && grid[newRow][newCol]=='1'){
                                q.offer(new int[]{newRow, newCol});
                                grid[newRow][newCol]='0';
                            }
                        }
                    }
                }
            }
        }
        return island;
    }
}
