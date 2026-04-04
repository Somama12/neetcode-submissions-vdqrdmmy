class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        for(char ch:tasks){
            count[ch-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int c:count){
            if(c>0){
                pq.offer(c);
            }
        }
        Queue<int[]> q=new LinkedList<>();
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int cnt=pq.poll()-1;
                if(cnt>0){
                    q.offer(new int[]{cnt, time+n});
                }
            }
            while(!q.isEmpty() && q.peek()[1]<=time){
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
