class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
         int max=Integer.MIN_VALUE;
        for(int pile:piles){
            max=Math.max(max, pile);
        }

           int ans = max;
        while(min <= max){
            int rate = min + (max - min)/2;
            int totalHour = 0;
            for(int p:piles){
                totalHour += (int) Math.ceil( (double)p/rate);
            }
            if(totalHour <= h){
                max = rate-1;
                ans = rate;
            }else{
                min = rate +1;
            }
        }
        return ans;
    }
}
