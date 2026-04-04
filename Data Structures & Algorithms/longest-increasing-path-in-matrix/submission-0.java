class Solution {
    int[][] memo;
    public int longestIncreasingPath(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        memo=new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(memo[i],-1);
        }
        int ans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                 ans = Math.max(ans, dp(matrix, i, j, new boolean[row][col], Integer.MIN_VALUE));
            }
        }
        return ans;
    }

    public int dp(int[][] matrix, int i, int j, boolean[][] visited, int prev){
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || visited[i][j] || matrix[i][j]<=prev){
            return 0;
        }
        if(memo[i][j]!=-1) return memo[i][j];

        visited[i][j]=true;
        int right=dp(matrix, i+1, j, visited, matrix[i][j]);
         int left=dp(matrix, i-1, j, visited, matrix[i][j]);
          int up=dp(matrix, i, j+1, visited, matrix[i][j]);
           int down=dp(matrix, i, j-1, visited, matrix[i][j]);
        visited[i][j]=false;
        memo[i][j] = 1+Math.max(Math.max(left,right), Math.max(up, down));
        return memo[i][j];
        
    }
}