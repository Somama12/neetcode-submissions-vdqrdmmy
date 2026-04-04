class KthLargest {
        private PriorityQueue<Integer> pq;
        private int kth;
    public KthLargest(int k, int[] nums) {
        this.kth=k;
        pq=new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>kth){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>kth){
            pq.poll();
        }
        return pq.peek();
    }
}
