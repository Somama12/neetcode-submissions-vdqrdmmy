class Solution {
    public int[][] memo;
    public int uniquePaths(int m, int n) {
        boolean[][] visited=new boolean[m][n];
        memo=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(0,0, m, n, visited);
    }

    public int dfs(int i, int j, int m, int n, boolean[][] visited){
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j]){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        visited[i][j]=true;
        int ans=dfs(i+1,j,m,n,visited)
                +dfs(i,j+1,m,n,visited);
        memo[i][j]=ans;
        visited[i][j]=false;
        return ans;
    }
}
