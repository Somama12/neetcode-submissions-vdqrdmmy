class Solution {
    public class Disjoint{
        int[] parent;
        int[] rank;
        int comps;
        public Disjoint(int n){
            this.parent=new int[n];
            this.rank=new int[n];
            this.comps=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public int findParent(int u){
            if(parent[u]==u) return u;
            parent[u]=findParent(parent[u]);
            return parent[u];
        }

        public boolean findUnion(int u, int v){
            int U=findParent(u);
            int V=findParent(v);
            if(U==V) return false;

            if(rank[U]>rank[V]){
                parent[V]=U;
            }else if(rank[V]>rank[U]){
                parent[U]=V;
            }else{
                parent[U]=V;
                rank[V]++;
            }
            comps--;
            return true;
        }
        public int components(){
            return comps;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        Disjoint ds=new Disjoint(n);
        for(int[] edge: edges){
            if(!ds.findUnion(edge[0],edge[1])){
                return false;
            }
        }
        return ds.components()==1;
    }
}
