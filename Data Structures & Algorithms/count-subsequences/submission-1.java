class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        memo=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(memo[i],-1);
        }
        return dp(s, t, 0,0);
    }

    public int dp(String s, String t, int i, int j){
        if(j==t.length()){
            return 1;
        }
        if(i>=s.length()){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int res=dp(s,t,i+1,j);
        if(s.charAt(i)==t.charAt(j)){
            res+= dp(s,t,i+1,j+1);
        }
        memo[i][j]=res;
        return res;
    }
}
