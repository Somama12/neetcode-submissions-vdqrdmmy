class Solution {
    public int numEnclaves(int[][] grid) {
        int row= grid.length;
        int col = grid[0].length;

        for(int i=0;i<col;i++){
            if(grid[0][i] == 1){
                dfs(0, i, grid);
            }

            if(grid[row-1][i] == 1){
                dfs(row-1, i, grid);
            }
        }

        for(int i=0;i<row;i++){
            if(grid[i][0] ==1){
                dfs(i, 0, grid);
            }

            if(grid[i][col-1] == 1){
                dfs(i, col-1, grid);
            }
        }

        int ans = 0;
        for(int i=0;i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        dfs(i+1, j, grid);
        dfs(i-1, j, grid);
        dfs(i, j+1, grid);
        dfs(i, j-1, grid);
    }
}