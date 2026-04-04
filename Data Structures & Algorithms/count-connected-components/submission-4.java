class Solution {
    public class Disjoint{
        int[] parent;
        int[] rank;
        int count;
        Disjoint(int n){
            parent=new int[n];
            rank=new int[n];
            count=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int findParent(int u){
            if(parent[u]==u) return parent[u];
            parent[u]=findParent(parent[u]);
            return parent[u];
        }
        public void findUnion(int u, int v){
            int U=findParent(u);
            int V=findParent(v);
            if(U==V) return;
            if(rank[U]>rank[V]){
                parent[V]=U;
            }else if(rank[V]>rank[U]){
                parent[U]=V;
            }else{
                parent[U]=V;
                rank[V]++;
            }
            count--;
        }
        public int getCount(){
            return count;
        }
    }
    public int countComponents(int n, int[][] edges) {
        Disjoint ds=new Disjoint(n);
        for(int[] edge: edges){
            ds.findUnion(edge[0], edge[1]);
        }
        return ds.getCount();
    }
}
