class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        int island = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    island++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] cell = q.poll();

                        for(int[] dir: directions){
                            int r = cell[0] + dir[0];
                            int c = cell[1] + dir[1];

                            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.offer(new int[]{r,c});
                            }
                        }
                    }

                }
            }
        }
                            return island;
    }
}
