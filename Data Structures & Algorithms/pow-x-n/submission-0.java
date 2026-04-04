class Solution {
    public double myPow(double x, int n) {
        double[] ans={1};
        recursion(x,Math.abs(n),ans);
        if(n>0) return ans[0];
        return (double) 1/ans[0];
    }
    public void recursion(double x, int n, double[] ans){
        if(n<=0) return;
        ans[0] = ans[0] * x;
        recursion(x, n-1, ans); 
    }
}
