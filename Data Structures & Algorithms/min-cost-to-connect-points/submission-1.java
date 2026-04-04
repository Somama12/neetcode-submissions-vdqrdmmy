class Solution {
    public class Disjoint{
        private int[] parent;
        private int[] rank;

        Disjoint(int n){
            parent=new int[n];
            rank=new int[n];
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
                parent[V]=U;
                rank[U]++;
            }
            return true;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        Disjoint ds=new Disjoint(n);
        List<int[]> edges=new ArrayList<>();

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int dist= Math.abs(points[i][0]-points[j][0])
                         + Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i,j,dist});
            }
        }
        edges.sort((a,b)->Integer.compare(a[2],b[2]));
        int res=0;
        for(int[] edge: edges){
            if(ds.findUnion(edge[0], edge[1])){
                res+=edge[2];
            }
        }
        return res;
    }
}
