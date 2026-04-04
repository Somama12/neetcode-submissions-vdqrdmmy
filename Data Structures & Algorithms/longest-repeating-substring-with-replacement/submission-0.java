class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            while( (i-left+1)-Collections.max(map.values())>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            res=Math.max(res,i-left+1);
        }
        return res;
    }
}
