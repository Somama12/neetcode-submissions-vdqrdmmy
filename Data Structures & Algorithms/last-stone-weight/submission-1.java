class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int s:stones){
            pq.offer(s);
        }
        while(pq.size()>1){
            int poll1=pq.poll();
            int poll2=pq.poll();
            int diff=poll1-poll2;
            if(diff==0){
                continue;
            }else{
                pq.offer(diff);
            }
        }
        return pq.size()==0?0:pq.peek();
    }
}
