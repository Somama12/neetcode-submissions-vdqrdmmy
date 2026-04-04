class Solution {
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int maxFreq=0;
        int ans=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            count[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq, count[s.charAt(r)-'A']);
            while( (r-l+1) - maxFreq > k ){
                count[s.charAt(l)-'A']--;
                l++;
            }
            ans=Math.max(ans, r-l+1);
        }
        return ans;
    }
}
