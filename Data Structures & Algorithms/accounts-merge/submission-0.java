class Solution {
    public class Disjoint{
        int[] parent;
        int[] rank;
        Disjoint(int n){
            this.parent=new int[n];
            this.rank=new int[n];
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
                parent[U]=V;
                rank[V]++;
            }
            return true;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        Disjoint ds=new Disjoint(n);
        Map<String, Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(map.containsKey(email)){
                    ds.findUnion(i, map.get(email));
                }else{
                    map.put(email,i);
                }
            }
        }
        ArrayList<String>[] emailGroup=new ArrayList[n];
        for(int i=0;i<n;i++){
            emailGroup[i]=new ArrayList<>();
        }

        for(String key:map.keySet()){
            int node=ds.findParent(map.get(key));
            emailGroup[node].add(key);
        }
        List<List<String>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(emailGroup[i].size()==0) continue;
            Collections.sort(emailGroup[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String email: emailGroup[i]){
                temp.add(email);
            }
            res.add(temp);
        }
        return res;
    }
}