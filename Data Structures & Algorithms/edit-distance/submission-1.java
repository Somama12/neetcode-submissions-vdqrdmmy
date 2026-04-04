class Solution {
    private int[][] memo;
    public int minDistance(String word1, String word2) {
        int i=word1.length()-1;
        int j=word2.length()-1;
        memo=new int[i+1][j+1];
        for(int k=0;k<=i;k++){
            Arrays.fill(memo[k],-1);
        }
        return dp(word1, word2, i, j);
    }
    public int dp(String w1, String w2, int i, int j){
        if(i<0) return j+1;
        if(j<0) return i+1;

        if(memo[i][j]!=-1) return memo[i][j];
        
        if(w1.charAt(i)==w2.charAt(j)){
            memo[i][j] = dp(w1, w2, i-1, j-1);
            return memo[i][j];
        }
        int insert=dp(w1,w2, i, j-1);
        int delete=dp(w1, w2, i-1,j);
        int replace=dp(w1, w2, i-1, j-1);
        
        memo[i][j] = 1+Math.min(insert, Math.min(delete, replace));
        return memo[i][j];
    }
}
