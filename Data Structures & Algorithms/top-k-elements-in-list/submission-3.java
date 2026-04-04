class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        List<Integer>[] freq=new List[nums.length+1];
        for(int i=0;i<=nums.length;i++){
            freq[i]=new ArrayList<>();
        }

        for(int key: map.keySet()){
            int frequency=map.get(key);
            freq[frequency].add(key);
        }

        int[] res=new int[k];
        int j=0;
        for(int i=freq.length-1; i>0 && j<k; i--){
            for(int num:freq[i]){
                res[j]=num;
                j++;
            }
        }
        return res;
    }
}
