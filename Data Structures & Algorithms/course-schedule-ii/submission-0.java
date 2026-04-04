class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            list.get(pre[1]).add(pre[0]);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] stack=new boolean[numCourses];
        Stack<Integer> newStack=new Stack<>();
        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i, numCourses, list,  visited, stack, newStack)){
                    return new int[0];
                }
            }
        }
        int i=0;
        while(!newStack.isEmpty()){
            result[i]=newStack.pop();
            i++;
        }
        return result;
    }
    public boolean dfs(int i, int n, List<List<Integer>> list, boolean[] visited, boolean[] stack, Stack<Integer> newStack){
        visited[i]=true;
        stack[i]=true;
        for(int neighbor: list.get(i)){
            if(stack[neighbor]){
                return true;
            }else if(!visited[neighbor] && dfs(neighbor, n,  list, visited, stack, newStack)){
                return true;
            }
        }
        stack[i]=false;
        newStack.add(i);
        return false;
    }
}
