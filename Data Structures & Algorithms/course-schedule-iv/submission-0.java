class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reachable=new boolean[numCourses][numCourses];

        for(int[] preq:prerequisites){
            reachable[preq[0]][preq[1]]=true;
        }

        for(int k=0;k<numCourses;k++){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    if( reachable[i][k] && reachable[k][j]){
                        reachable[i][j]=true;
                    }
                }
            }
        }

        List<Boolean> res=new ArrayList<>();
        for(int[] query: queries){
            res.add(reachable[query[0]][query[1]]);
        }
        return res;
    }
}