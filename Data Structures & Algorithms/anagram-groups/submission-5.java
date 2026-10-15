class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for(String st : strs){
            char[] arr = st.toCharArray();
            int[] count = new int[26];
            for(char ch : arr){
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(st);
        }

        return new ArrayList<>(result.values());
    }
}
