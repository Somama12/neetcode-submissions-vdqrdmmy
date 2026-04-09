class Solution {
    public class Disjoint{
        int[] parent;
        int[] rank;
        int comps;

        public Disjoint(int n){
            this.comps = n;
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(rank, 0);

            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }

        public int findParent(int u){
            if(parent[u] ==u) return u;
            parent[u] = findParent(parent[u]);
            return parent[u];
        }

        public int getComps(){
            return comps;
        }

        public boolean findUnion(int u, int v){
            int parentU = findParent(u);
            int parentV = findParent(v);

            if(parentU == parentV) return false;

            if(rank[parentU] > rank[parentV]){
                parent[parentV] = parentU;
            }else if(rank[parentV] > rank[parentU]){
                parent[parentU] = parentV;
            }else{
                parent[parentU] = parentV;
                rank[parentV] ++;
            }
            comps--;
            return true;
        }
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1) return false;
        Disjoint ds = new Disjoint(n);
        for(int[] e: edges){
            if(!ds.findUnion(e[0], e[1])){
                return false;
            }
        }

        return ds.getComps() == 1;
    }
}
