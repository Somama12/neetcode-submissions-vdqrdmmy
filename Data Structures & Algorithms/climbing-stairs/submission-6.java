class Solution {
    public int climbStairs(int n) {
        return recursion(1,n)+recursion(2,n);
    }
    public int recursion(int i, int n){
        if(i>n) return 0;
        if(i==n){
            return 1;
        }
        return recursion(i+1,n)+recursion(i+2,n);
    }
}
