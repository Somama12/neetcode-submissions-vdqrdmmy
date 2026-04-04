class Solution {
    int[] memo;
    public int dp(int[] coins, int amount){
        if(amount==0) return 0;
        if(memo[amount]!=-2) return memo[amount];
        int res=(int)1e9;
        for(int coin: coins){
            if(amount-coin>=0){
                res=Math.min(res, 1+dp(coins, amount-coin));
            }
        }
        memo[amount]=res;
        return res;
    }
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        memo=new int[amount+1];
        Arrays.fill(memo,-2);
        int ans= dp(coins, amount);
        return ans>=1e9?-1:ans;
    }
}
