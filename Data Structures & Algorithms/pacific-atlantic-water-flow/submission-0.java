class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] atl=new boolean[row][col];
        boolean[][] pac=new boolean[row][col];
        for(int i=0;i<col;i++){
            dfs(0, i, pac, heights[0][i], heights);
            dfs(row-1, i, atl, heights[row-1][i], heights);
        }
        for(int i=0;i<row;i++){
            dfs(i, 0, pac, heights[i][0], heights);
            dfs(i, col-1, atl, heights[i][col-1], heights);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(atl[i][j] && pac[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public void dfs(int r, int c, boolean[][] visit, int height, int[][] heights){
        if(r<0 || c<0 || r>=heights.length || c>=heights[0].length || visit[r][c]){
            return;
        }
        if(heights[r][c]<height){
            return;
        }
        visit[r][c]=true;
        height=heights[r][c];
        dfs(r+1, c, visit, height, heights);
        dfs(r-1, c, visit, height, heights);
        dfs(r, c+1, visit, height, heights);
        dfs(r, c-1, visit, height, heights);
    }
}
