class Solution {
    private int count;
    public class DisjointSet{
        private int[] rank;
        private int[] parent;

        public DisjointSet(int n){
            rank=new int[n];
            parent=new int[n];
            Arrays.fill(rank,0);
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
            int pu=findParent(u);
            int pv=findParent(v);
            if(pu!=pv){
                if(rank[pu]<rank[pv]){
                    parent[pu]=pv;
                }else if(rank[pu]>rank[pv]){
                    parent[pv]=pu;
                }else{
                    parent[pu]=pv;
                    rank[pv]++;
                }
                count--;
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        this.count=n;
        DisjointSet DS=new DisjointSet(n);
        for(int[] edge:edges){
            DS.findUnion(edge[0],edge[1]);
        }
        return count;
    }
}
