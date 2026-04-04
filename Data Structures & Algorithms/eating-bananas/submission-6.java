class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end=Integer.MIN_VALUE;
        for(int pile:piles){
            end=Math.max(pile, end);
        }
        int ans=end;
        while(start<=end){
            int rate=start+(end-start)/2;
            int hours=0;
            for(int pile:piles){
                hours+=(int) Math.ceil( (double)pile/rate);
            }
            if(hours<=h){
                ans=rate;
                end=rate-1;
            }else{
                start=rate+1;
            }
        }
        return ans;
    }
}
