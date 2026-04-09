class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        int[][] directions = {{0,-1}, {0,1},{-1,0},{1,0}};
        int perimeter = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] cell = q.poll();

                        for(int[] dir: directions){
                            int r = cell[0] + dir[0];
                            int c = cell[1] + dir[1];

                            if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0){
                                perimeter++;
                            }else if(!visited[r][c]){
                                visited[r][c] = true;
                                q.offer(new int[]{r,c});
                            }
                        }
                    }
                     return perimeter;
                }
            }
        }
            return 0;
    }

}