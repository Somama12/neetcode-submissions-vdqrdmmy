class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] time:times){
            int u=time[0];
            int v=time[1];
            int w=time[2];
            list.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) ->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k,0});
        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;
        boolean[] visited=new boolean[n+1];
        while(!pq.isEmpty()){
            int[] cell=pq.poll();
            int u=cell[0];
            int w1=cell[1];
            if(visited[u]) continue;
            visited[u]=true;
            for(int[] neighbor:list.get(u)){
                int v=neighbor[0];
                int w2=neighbor[1];

                if(!visited[v] && dist[v]>w2+w1){
                    dist[v]=w2+w1;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max, dist[i]);
        }
        return max;

    }
}
