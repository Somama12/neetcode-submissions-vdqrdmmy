class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int maxF=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            maxF=Math.max(maxF, map.get(s.charAt(i)));
            while( (i-left+1)-maxF>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            res=Math.max(res,i-left+1);
        }
        return res;
    }
}
