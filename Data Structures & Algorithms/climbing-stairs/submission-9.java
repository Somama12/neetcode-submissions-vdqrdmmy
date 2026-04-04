class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return dp(n, 0, cache);
    }

    public int dp(int n, int i, int[] cache){
        if(i==n) return 1;
        if(i>n) return 0;
        if(cache[i]!=-1) return cache[i];

        cache[i] = dp(n, i+1, cache) + dp(n, i+2, cache);
        return cache[i];
    }
}
