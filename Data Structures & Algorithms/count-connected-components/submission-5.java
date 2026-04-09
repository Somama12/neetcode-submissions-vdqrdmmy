class Solution {
    public class Disjoint{
        int[] parent;
        int[] rank;
        int comp;

        public Disjoint(int n){
            this.comp = n;
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 0);

            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }
        public int getComp(){
            return comp;
        }
        public int findParent(int u){
            if(parent[u] == u) return u;
            parent[u] = findParent(parent[u]);
            return parent[u];
        }

        public boolean findUnion(int i, int j){
            int u = findParent(i);
            int v = findParent(j);

            if(u==v) return false;

            if(rank[u] > rank[v]){
                parent[v] = u;
            }else if(rank[v] > rank[u]){
                parent[u] = v;
            }else{
                parent[u] = v;
                rank[v]++;
            }
            comp--;
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        Disjoint ds = new Disjoint(n);

        for(int[] e: edges){
            ds.findUnion(e[0],e[1]);
        }

        return ds.getComp();
    }
}
