class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] visited=new boolean[n];
        if(dfs(0,-1,list, visited)){
            return false;
        }
        for(boolean V: visited){
            if(!V) return false;
        }
        return true;
    }

    public boolean dfs(int i, int parent, List<List<Integer>> list, boolean[] visited){
        visited[i]=true;
        for(int neighbor: list.get(i)){
            if(!visited[neighbor]){
                if(dfs(neighbor, i, list, visited)){
                    return true;
                }
            }else if(neighbor!=parent){
                return true;
            }
        }
        return false;
    }
}
