class Solution {
    public int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo=new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(text1, text2, 0, 0);
    }

    public int dfs(String w1, String w2, int i, int j){
        if(i==w1.length() || j==w2.length()){
            return 0;
        }
        if(memo[i][j]!=-1) return memo[i][j];

        if(w1.charAt(i)==w2.charAt(j)){
            memo[i][j]= 1+dfs(w1,w2, i+1, j+1);
            return memo[i][j];
        }

        int first=dfs(w1,w2,i+1,j);
        int second=dfs(w1,w2,i,j+1);
        memo[i][j] = Math.max(first, second);
        return memo[i][j];
    }
}
