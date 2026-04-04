class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1]; // size n+1 to include index n
        Arrays.fill(memo, -1);
        return dp(0, n, memo); // start from step 0
    }

    private int dp(int i, int n, int[] memo) {
        if (i > n) return 0;
        if (i == n) return 1; // reached the top
        if (memo[i] != -1) return memo[i];

        memo[i] = dp(i + 1, n, memo) + dp(i + 2, n, memo);
        return memo[i];
    }
}
