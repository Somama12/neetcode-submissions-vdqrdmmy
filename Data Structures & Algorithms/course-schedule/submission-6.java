class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            int u=preq[0];
            int v=preq[1];
            list.get(u).add(v);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] stack=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i, list, visited, stack)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int i,List<List<Integer>> list,boolean[] visited,boolean[] stack){
        visited[i]=true;
        stack[i]=true;
        for(int neighbor: list.get(i)){
            if(stack[neighbor]){
                return true;
            }else if(!visited[neighbor] && dfs(neighbor, list, visited, stack)){
                return true;
            }
        }
        stack[i]=false;
        return false;
    }
}
