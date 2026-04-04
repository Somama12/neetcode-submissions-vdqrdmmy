class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            int u=preq[0];
            int v=preq[1];
            list.get(v).add(u);
        }
        boolean[] stack=new boolean[numCourses];
        boolean[] visited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i, stack, visited, list)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int i, boolean[] stack, boolean[] visited, List<List<Integer>> list){
        visited[i]=true;
        stack[i]=true;
        for(int neighbor:list.get(i)){
            if(!visited[neighbor]){
                if(dfs(neighbor, stack, visited, list)){
                    return true;
                }
            }else if(stack[neighbor]){
                return true;
            }
        }
        stack[i]=false;
        return false;
    }
}
