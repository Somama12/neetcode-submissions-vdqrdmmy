class Solution {
    public int maxProfit(int[] prices) {
        int profit=Integer.MIN_VALUE;
        int l=0;
        for(int r=1;r<prices.length;r++){
            if(prices[r]>prices[l]){
                profit=Math.max(prices[r]-prices[l], profit);
            }else{
                l=r;
            }
        }
        return profit==Integer.MIN_VALUE?0:profit;
    }
}
