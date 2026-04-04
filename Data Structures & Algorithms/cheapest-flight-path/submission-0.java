class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] flight: flights){
            int f=flight[0];
            int t=flight[1];
            int p=flight[2];
            list.get(f).add(new int[]{t,p});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,src,0});
        int[] dist=new int[n];
        int[] stops=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        dist[src]=0;
        stops[src]=0;
        while(!pq.isEmpty()){
            int[] node=pq.poll();
            int cost=node[0];
            int f=node[1];
            int stop=node[2];
            if(f==dst) return cost;
            if(stop>k) continue;
            for(int[] neighbor: list.get(f)){
                int t=neighbor[0];
                int w=neighbor[1];
                if(dist[t]>cost+w || stop+1<stops[t]){
                    dist[t]=cost+w;
                    stops[t]=stop+1;
                    pq.offer(new int[]{dist[t],t, stops[t]});
                }
            }
        }
        return -1;
    }
}
