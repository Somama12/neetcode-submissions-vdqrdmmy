class Solution {
    public boolean isMatch(String s, String p) {
        return dp(s, p, 0,0);
    }
    public boolean dp(String s, String p, int i, int j){
        if(j==p.length()) return i==s.length();
        boolean match=(i<s.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'));

        if(j+1<p.length() && p.charAt(j+1)=='*'){
            return dp(s,p,i,j+2) || (match && dp(s,p,i+1,j));
        }else{
            return match && dp(s,p,i+1, j+1);
        }
    }
}
