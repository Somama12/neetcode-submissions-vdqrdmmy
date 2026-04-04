class Solution {
    public int findJudge(int n, int[][] trust) {
        int j=1;
        for(int i=0;i<trust.length;i++){
            if(i+1<trust.length && trust[i][j]!=trust[i+1][j]){
                return -1;
            }
        }
        return trust[0][1];
    }
}