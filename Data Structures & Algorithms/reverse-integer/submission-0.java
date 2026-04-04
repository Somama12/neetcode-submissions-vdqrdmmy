class Solution {
    public int reverse(int x) {
      
        if(x==0) return 0;
        long ans=0;
        int sign = x < 0 ? -1 : 1;
        x=Math.abs(x);
        while(x>0){
            int rem=x%10;
            ans=ans*10+rem;
            if(ans>Integer.MAX_VALUE){
                return 0;
            }
            x=x/10;
        }
        return (int)ans*sign;
    }
}