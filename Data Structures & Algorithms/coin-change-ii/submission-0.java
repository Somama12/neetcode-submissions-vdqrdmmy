class Solution {
    HashMap<String, Integer> map=new HashMap<>();
    public int change(int amount, int[] coins) {
        return dp(amount, coins, 0);
    }
    public int dp(int amount, int[] coins, int i){
        if(amount==0) return 1;
        if(amount<0 || i>=coins.length) return 0;
        String key=i+","+amount;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int take=dp(amount-coins[i], coins, i);
        int skip=dp(amount, coins, i+1);
        map.put(key, take+skip);
        return take+skip;
    }
}
