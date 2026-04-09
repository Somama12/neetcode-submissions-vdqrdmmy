class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] e : edges){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        int comp = 0;
        boolean[] visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                comp++;
                dfs(i, list, visited);
            }
        }
        return comp;
    }

    public void dfs(int i, List<List<Integer>> list, boolean[] visited){
        visited[i] = true;

        for(int neigh: list.get(i)){
            if(!visited[neigh]){
                dfs(neigh, list, visited);
            }
        }
    }
}
