class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        for(int s : stones){
            pq.offer(s);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            int diff = Math.abs( first - second);

            if(diff > 0){
                pq.offer(diff);
            }
        }

        if(pq.isEmpty()) return 0;
        return pq.poll();
    }
}
