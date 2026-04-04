class Solution {
    public int maxProfit(int[] prices) {
        int left=0;
        int max=0;
        for(int right=1;right<prices.length;right++){
            int current=0;
            if(prices[left]<prices[right]){
                current=prices[right]-prices[left];
            }else{
                left=right;
            }
            max=Math.max(current,max);
        }
        return max;
    }
}
