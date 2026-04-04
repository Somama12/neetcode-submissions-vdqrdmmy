class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res=new ArrayList<>();

        if(n==0) return res;

        if(n==1){
            res.add(0);
            return res;
        }
        int[] degree=new int[n];

        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            degree[u]++;
            degree[v]++;
            list.get(u).add(v);
            list.get(v).add(u);
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            if(n<=2) return new ArrayList<>(q);
            for(int i=0;i<size;i++){
                int node=q.poll();
                n--;
                for(int nei:list.get(node)){
                    degree[nei]--;
                    if(degree[nei]==1){
                        q.offer(nei);
                    }
                }
            }
        }
        return res;
        

    }
}