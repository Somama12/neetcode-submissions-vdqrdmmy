class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int[] preq: prerequisites){
            int u = preq[0];
            int v = preq[1];
            list.get(u).add(v);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(!visited[i] && dfs(i, visited, stack, list)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, boolean[] visited, boolean[] stack, List<List<Integer>> list){
        visited[i] = true;
        stack[i] = true;

        for(int neig: list.get(i)){
            if(stack[neig]){
                return true;
            }else if(!visited[neig] && dfs(neig, visited, stack, list)){
                return true;
            }
        }
        stack[i] = false;
        return false;

    }
}
