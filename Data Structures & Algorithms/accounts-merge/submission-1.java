class Solution {
    public class Disjoint{
        int[] rank;
        int[] parent;
        public Disjoint(int n){
            this.rank = new int[n];
            this.parent = new int[n];

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
            int U = findParent(u);
            int V = findParent(v);

            if(U==V) return;
            if(rank[U] > rank[V]){
                parent[V] = U;
            }else if(rank[V] > rank[U]){
                parent[U] = V;
            }else{
                parent[U] = V;
                rank[V]++;
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Disjoint ds = new Disjoint(n);

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)){
                    ds.findUnion(i, map.get(mail));
                }else{
                    map.put(mail, i);
                }
            }
        }

        ArrayList<String>[] res1 = new ArrayList[n];

        for(int i=0; i<n; i++){
            res1[i] = new ArrayList<>();
        }

        for(String key : map.keySet()){
            int node = ds.findParent(map.get(key));
            res1[node].add(key);
        }

        List<List<String>> res = new ArrayList<>();

        for(int i=0; i<n ; i++){
            if(res1[i].size()==0) continue;
            Collections.sort(res1[i]);
            List<String> inner = new ArrayList<>();
            inner.add(accounts.get(i).get(0));
            for(String email: res1[i]){
                inner.add(email);
            }
            res.add(inner);
        }
        return res;
    }
}