class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(0,0,obstacleGrid, dp);
    }
    public int dfs(int i, int j, int[][] grid, int[][] dp){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==1){
            return 0;
        }
        if(i==grid.length-1 && j==grid[0].length-1){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        dp[i][j]= dfs(i+1,j,grid,dp)+dfs(i,j+1, grid, dp);
        return dp[i][j];
    }
}