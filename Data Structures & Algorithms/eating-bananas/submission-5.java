class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start=1;
        int end=piles[piles.length-1];
        int ans=end;
        while(start<=end){
            int rate=start+(end-start)/2;
            int hours=0;
            for(int pile:piles){
                hours+=(int)Math.ceil((double)pile/rate);
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
