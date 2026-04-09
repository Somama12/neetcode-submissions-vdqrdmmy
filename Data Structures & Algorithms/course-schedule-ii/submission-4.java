class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            list.add(new ArrayList<>());
        }

        for(int[] preq: prerequisites){
            int u = preq[0];
            int v = preq[1];
            list.get(v).add(u);
        }

        boolean[] stack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(dfs(i, stack, visited, s, list)){
                    return new int[]{};
                }
            }
        }
        int[] res = new int[numCourses];
        int k=0;
        while(!s.isEmpty()){
            res[k++] = s.pop();
        }
        return res;
    }

    public boolean dfs(int i, boolean[] stack, boolean[] visited, Stack<Integer> s, List<List<Integer>> list){
        stack[i] = true;
        visited[i] = true;

        for(int neigh: list.get(i)){
            if(stack[neigh]){
                return true;
            }else if(!visited[neigh] && dfs(neigh, stack, visited, s, list)){
                return true;
            }
        }
        stack[i] = false;
        s.push(i);
        return false;
    }
}
