class Solution {
    public class Disjoint{
        int[] parent;
        int[] rank;

        public Disjoint(int n){
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 0);

            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }

        public int findParent(int u){
            if(parent[u] == u) return u;
            parent[u] = findParent(parent[u]);
            return parent[u];
        }

        public void findUnion(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return;
            
            if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }else if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }else{
                parent[pu] = pv;
                rank[pv]++;
            }
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        List<int[]> edges = new ArrayList<>();
        Disjoint DS = new Disjoint(rows*cols);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r + 1 < rows) {
                    edges.add(new int[]{Math.abs(heights[r][c] - heights[r + 1][c]), r * cols + c, (r + 1) * cols + c});
                }
                if (c + 1 < cols) {
                    edges.add(new int[]{Math.abs(heights[r][c] - heights[r][c + 1]), r * cols + c, r * cols + c + 1});
                }
            }
        }
        Collections.sort(edges, (a, b) -> a[0] - b[0]);
        int res = 0;
        for(int[] edge : edges){
            DS.findUnion(edge[1], edge[2]);
           
            if(DS.findParent(0) == DS.findParent(rows*cols-1)){
                return edge[0];
            }
        }
        return 0;
    }
}