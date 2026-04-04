class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list=new ArrayList<>();
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] pac=new boolean[row][col];
        boolean[][] atl=new boolean[row][col];
        for(int i=0;i<col;i++){
            dfs(0, i, pac, heights[0][i],heights);
            dfs(row-1, i, atl, heights[row-1][i],heights);
        }
        for(int i=0;i<row;i++){
            dfs(i, 0, pac, heights[i][0], heights);
            dfs(i, col-1, atl, heights[i][col-1], heights);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pac[i][j] && atl[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    public void dfs(int i, int j, boolean[][] visit, int height, int[][] heights){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length || visit[i][j]){
            return;
        }
        if(heights[i][j]<height){
            return;
        }
        visit[i][j]=true;
        height=heights[i][j];
        dfs(i+1,j,visit, height, heights);
        dfs(i-1,j,visit, height, heights);
        dfs(i,j+1,visit, height, heights);
        dfs(i,j-1,visit, height, heights);
    }
}
