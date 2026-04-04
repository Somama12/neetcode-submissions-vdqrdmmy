class Solution {
    public int islandPerimeter(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        boolean[][] visited=new boolean[row][col];
        int perimeter=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    perimeter=dfs(i,j, grid, visited);
                }
            }
        }
        return perimeter;
    }
    public int dfs(int i, int j, int[][] grid, boolean[][] visited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return 1;
        }
        if(visited[i][j]) return 0;
        visited[i][j]=true;
        return dfs(i+1,j,grid, visited)
            +  dfs(i-1,j,grid, visited)
            + dfs(i,j+1,grid, visited)
            +dfs(i,j-1,grid, visited);
    }
}