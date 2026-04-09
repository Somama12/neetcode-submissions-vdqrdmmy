class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    int[] area = {0};
                    dfs(i, j, grid, area);
                    ans = Math.max(ans, area[0]);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int[][] grid, int[] area){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0){
            return;
        }

        area[0] += 1;
        grid[i][j] = 0;
        dfs(i+1, j, grid, area);
        dfs(i-1, j, grid, area);
        dfs(i, j+1, grid, area);
        dfs(i, j-1, grid, area);
    }
}
