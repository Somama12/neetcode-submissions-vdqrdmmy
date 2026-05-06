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
        boolean[] visited = new boolean[n+1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int w = node[0];
            int u = node[1];

            if(visited[u]) continue;
            visited[u] = true;

            for(int[] neigh : list.get(u)){
                int v = neigh[0];
                int weight = neigh[1];
                if(!visited[v] && dist[v] > w + weight){
                    dist[v] = w + weight;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int ans = Integer.MIN_VALUE;

        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}
