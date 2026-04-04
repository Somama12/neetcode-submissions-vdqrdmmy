class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return bfs(i, j, grid, visited);
                }
            }
        }
        return 0;
    }
    public int bfs(int i, int j, int[][] grid, boolean[][] visited){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0
          || grid[i][j]==0){
            return 1;
          } 
        if(visited[i][j]){
            return 0;
        }
        visited[i][j]=true;
        return bfs(i+1, j, grid, visited)
            + bfs(i-1, j, grid, visited)
            + bfs(i, j+1, grid, visited)
            + bfs(i, j-1, grid, visited);
    }
}