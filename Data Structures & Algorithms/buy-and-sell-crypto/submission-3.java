class Solution {
    public int maxProfit(int[] prices) {
        int left=0;
        int maxProfit=0;
        for(int right=1;right<prices.length;right++){
            int currentProfit=0;
            if(prices[right]-prices[left]>0){
                currentProfit=prices[right]-prices[left];
            }else{
                left=right;
            }
            maxProfit=Math.max(currentProfit, maxProfit);
        }
        return maxProfit;
    }
}
