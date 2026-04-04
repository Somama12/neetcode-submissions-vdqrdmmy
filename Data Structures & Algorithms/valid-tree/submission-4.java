class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        List<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        boolean[] visited=new boolean[n];

        if(dfs(0,-1, visited, list)){
            return false;
        }

        for(boolean V:visited){
            if(!V) return false;
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
            }else if(parent!=neighbor){
                return true;
            }
        }
        return false;
    }
}
