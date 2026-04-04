class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while(pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            int diff=Math.abs(x-y);
            if(diff>0){
                pq.offer(diff);
            }
           
        }
         return pq.isEmpty()?0:pq.poll();
    }
}
