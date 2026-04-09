class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int min = 0;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        while(fresh>0 && !q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] cell = q.poll();
                for(int[] dir: directions){
                    int r = dir[0] + cell[0];
                    int c = dir[1] + cell[1];

                    if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        q.offer(new int[]{r,c});
                    }
                }
            }
            min++;
        }
        return fresh!=0?-1:min;
    }
}
