class Solution {
    Map<String, Integer> map;
    public int maxProfit(int[] prices) {
        map=new HashMap<>();
        return dp(prices, 0, true);
    }
    public int dp(int[] prices, int i, boolean buy){
        if(i>=prices.length) return 0;
        String key=i+","+buy;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int cooldown=dp(prices, i+1, buy);
        if(buy){
            int profit=dp(prices, i+1, false)-prices[i];
            map.put(key,Math.max(cooldown, profit));
             return map.get(key);
        }else{
            int profit=dp(prices, i+2, true)+prices[i];
            map.put(key,Math.max(cooldown, profit));
             return map.get(key);

        }
    }
}