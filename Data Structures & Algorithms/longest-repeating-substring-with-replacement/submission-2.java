class Solution {
    public int characterReplacement(String s, int k) {
       HashMap<Character, Integer> map=new HashMap<>();
       int left=0;
       int count=0;
       int maxF=0;
       for(int right=0;right<s.length();right++){
        map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
        maxF=Math.max(maxF,map.get(s.charAt(right)));
        while( (right-left+1)-maxF>k ){
            map.put(s.charAt(left),map.get(s.charAt(left))-1);
            left++;
        }
        count=Math.max(count, right-left+1);
       }
       return count;
    }
}
