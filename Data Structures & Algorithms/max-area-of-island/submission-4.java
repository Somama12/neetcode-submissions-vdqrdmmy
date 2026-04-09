class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int ans = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    int area = 1;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    grid[i][j] = 0;
                    while(!q.isEmpty()){
                        int[] cell = q.poll();
                        for(int[] dir: directions){
                            int r = dir[0] + cell[0];
                            int c = dir[1] + cell[1];

                            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == 1){
                                area += 1;
                                grid[r][c] = 0;
                                q.offer(new int[]{r,c});
                            }
                        }
                    }
                    ans = Math.max(area, ans);
                }
            }
        }
        return ans;
    }
}
