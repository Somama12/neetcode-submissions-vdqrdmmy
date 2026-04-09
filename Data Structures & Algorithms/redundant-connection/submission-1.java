class Solution {
    public class DisjointSet {
        private int[] rank;
        private int[] parent;

        public DisjointSet(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 0; i <= size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int findParent(int u) {
            if (u == parent[u]) return u;
            parent[u] = findParent(parent[u]);
            return parent[u];
        }

        public void findUnion(int u, int v) {
            int ultU = findParent(u);
            int ultV = findParent(v);
            if (ultU == ultV) return;

            if (rank[ultU] > rank[ultV]) {
                parent[ultV] = ultU;
            } else if (rank[ultU] < rank[ultV]) {
                parent[ultU] = ultV;
            } else {
                parent[ultU] = ultV;
                rank[ultV]++;
            }
        }

        public boolean isConnected(int u, int v) {
            return findParent(u) == findParent(v);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (ds.isConnected(u, v)) {
                return new int[]{u, v};
            } else {
                ds.findUnion(u, v);
            }
        }

        return new int[]{-1, -1}; // Should never happen for valid input
    }
}
