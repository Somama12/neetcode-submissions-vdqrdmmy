class Solution {
    public class Disjoint{
        private int[] rank;
        private int[] parent;
        private int comp;

        Disjoint(int n){
            this.rank=new int[n];
            this.parent=new int[n];
            this.comp=n;
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
            }else if(rank[U]<rank[V]){
                parent[U]=V;
            }else{
                parent[V]=U;
                rank[U]++;
            }
            comp--;
            return true;
        }
        public int component(){
            return comp;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;

        Disjoint ds=new Disjoint(n);

        for(int[] edge:edges){
            if(!ds.findUnion(edge[0],edge[1])){
                return false;
            }
        }
    return ds.component()==1;
    }
}
