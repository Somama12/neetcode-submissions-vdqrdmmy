class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            map.get(preq[0]).add(preq[1]);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] stack=new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i, map, visited, stack)){
                    return false;
                }
            }
        }
    return true;
    }

    public boolean dfs(int i, Map<Integer, List<Integer>> map, boolean[] visit, boolean[] stack){
        visit[i]=true;
        stack[i]=true;
        for(int neighbor: map.get(i)){
            if(stack[neighbor]){
                return true;
            }else if(!visit[neighbor] && dfs(neighbor, map, visit, stack)){
                return true;
            }
        }
        stack[i]=false;
        return false;
    }
}
