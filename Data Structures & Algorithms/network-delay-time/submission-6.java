class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] t: times){
            int u = t[0];
            int v = t[1];
            int w = t[2];
            list.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});
        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int u = node[0];
            int w = node[1];
            visited[u] = true;
            for(int[] neigh : list.get(u)){
                int v = neigh[0];
                int d = neigh[1];

                if(!visited[v] && dist[v] > d+w){
                    dist[v] = d + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        int ans = 0;
        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(dist[i], ans);
        }
        return ans;
    }
}
