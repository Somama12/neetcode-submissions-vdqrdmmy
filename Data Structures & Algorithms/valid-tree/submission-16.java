class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                if(dfs(i, -1,  list, visited)){
                    return false;
                }
            }
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int i, int parent, List<List<Integer>> list, boolean[] visited){
        visited[i] = true;

        for(int neigh: list.get(i)){
            if(!visited[neigh]){
                if(dfs(neigh, i, list, visited)){
                    return true;
                }
            }else if(neigh!=parent){
                return true;
            }
        }
        return false;
    }
}
