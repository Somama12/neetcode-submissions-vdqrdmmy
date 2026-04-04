class Solution {
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
        public boolean findUnion(int u, int v){
            int pU=findParent(u);
            int pV=findParent(v);
            if(pU==pV) return false;
            if(rank[pU]<rank[pV]){
                parent[pU]=pV;
            }
            else if(rank[pU]>rank[pV]){
                parent[pV]=pU;
            }else{
                parent[pU]=pV;
                rank[pV]++;
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        DisjointSet DS=new DisjointSet(n);
        List<int[]> edges=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist=Math.abs( points[i][0] - points[j][0])
                        + Math.abs( points[i][1] - points[j][1] );
                edges.add(new int[]{i,j,dist});
            }
        }
        edges.sort((a,b) -> Integer.compare(a[2],b[2]));
        int res=0;
        for(int[] edge: edges){
            if (DS.findUnion(edge[0], edge[1])) {
                res += edge[2];
            }
        }
        return res;
    }
}