class Solution {
    private int count;

    public class Disjoint{
        private int[] parent;
        private int[] rank;

        public Disjoint(int n){
            this.parent=new int[n];
            this.rank=new int[n];
            Arrays.fill(rank, 0);
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int findParent(int u){
            if(parent[u]==u) return u;
            parent[u]=findParent(parent[u]);
            return parent[u];
        }

        public void findUnion(int u, int v){
            int pU=findParent(u);
            int pV=findParent(v);
            if(pU!=pV){
                if(rank[pU]<rank[pV]){
                    parent[pU]=pV;
                }else if(rank[pU]>rank[pV]){
                    parent[pV]=pU;
                }else{
                    parent[pU]=pV;
                    rank[pV]++;
                }
                  count--;
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
            this.count=n;
            Disjoint ds=new Disjoint(n);
            for(int[] edge:edges){
                ds.findUnion(edge[0],edge[1]);
            }
            return count;
    }
}
