class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

      
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(map.get(a),map.get(b)));

        for (int key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // build result
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}
