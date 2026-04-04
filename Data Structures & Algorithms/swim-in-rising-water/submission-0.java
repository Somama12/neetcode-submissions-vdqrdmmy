class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        int maxElev=0;
        while(!pq.isEmpty()){
            int[] node=pq.poll();
            int elev=node[0];
            int r=node[1];
            int c=node[2];
            maxElev=Math.max(elev, maxElev);
            if(r==n-1 && c==n-1) return maxElev;
            for(int[] dr: directions){
                int i=dr[0]+r;
                int j=dr[1]+c;

                if(i>=0 && j>=0 && i<n && j<n && !visited[i][j]){
                    pq.offer(new int[]{grid[i][j], i, j});
                    visited[i][j]=true;
                }
            }
        }
        return -1;
    }
}
