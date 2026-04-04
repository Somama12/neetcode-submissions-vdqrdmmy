class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(recursion(cost, 0), recursion(cost,1));
    }
    public int recursion(int[] cost, int i){
        if(i>=cost.length) return 0;
        int left= cost[i]+recursion(cost, i+1);
        int right=cost[i]+recursion(cost, i+2);
        return Math.min(left, right);
    }
}