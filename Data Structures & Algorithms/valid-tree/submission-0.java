class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        if (dfs(0, -1, visited, list)) {
            return false;  
        }
        for(boolean v:visited){
            if(!v) return false;
        }
        return true;
    }
    public boolean dfs(int i, int parent, boolean[] visited, List<List<Integer>> list){
        visited[i]=true;
        for(int neighbor:list.get(i)){
            if(!visited[neighbor]){
                if(dfs(neighbor, i, visited, list)){
                    return true;
                }
                }else if(neighbor!=parent){
                    return true;
            }
        }
        return false;
    }
}
