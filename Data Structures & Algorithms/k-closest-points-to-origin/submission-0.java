class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]>  pq=new PriorityQueue<>( (a,b) ->Double.compare(a[2],b[2]));
        for(int[] point:points){
            int u=point[0];
            int v=point[1];
            double dist=Math.sqrt( (u*u) + (v*v) );
            pq.offer(new double[]{u,v,dist});
        }
        int[][] ans=new int[k][2];
        for(int i=0;i<k;i++){
            double[] cell=pq.poll();
            ans[i][0] = (int) cell[0];
            ans[i][1] = (int) cell[1];
        }
        return ans;
    }
}