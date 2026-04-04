class Solution {
    class Disjoint{
        private int[] parent;
        private int[] rank;
        private int comp;

        public Disjoint(int n){
            parent=new int[n];
            rank=new int[n];
            Arrays.fill(rank, 0);
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
            comp=n;
        }

        public int findParent(int u){
            if(parent[u]==u) return u;
            parent[u]=findParent(parent[u]);
            return parent[u];
        }

        public int component(){
            return comp;
        }
        public boolean findUnion(int u, int v){
            int pU=findParent(u);
            int pV=findParent(v);
            if(pU==pV) return false;

            if(rank[pU]>rank[pV]){
                parent[pV]=pU;
            }else if(rank[pU]<rank[pV]){
                parent[pU]=pV;
            }else{
                parent[pU]=pV;
                rank[pV]++;
               
            }
             comp--;
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1){
            return false;
        }
        
        Disjoint ds=new Disjoint(n);
        for(int[] edge:edges){
            if(!ds.findUnion(edge[0],edge[1])){
                return false;
            }
        }
        return ds.component()==1;
    }
}
