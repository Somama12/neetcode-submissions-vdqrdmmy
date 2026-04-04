class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] time: times){
            int u=time[0];
            int v=time[1];
            int w=time[2];
            list.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        pq.offer(new int[]{k,0});
        boolean[] visited=new boolean[n+1];
        while(!pq.isEmpty()){
            int[] cell=pq.poll();
            int node=cell[0];
            int d=cell[1];
            if(visited[node]) continue;
            visited[node]=true;
            for(int[] neighbor: list.get(node)){
                int v=neighbor[0];
                int w=neighbor[1];
                if(!visited[v] && dist[v]>d+w){
                    dist[v]=d+w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans, dist[i]);
        }
        return ans;
    }
}
