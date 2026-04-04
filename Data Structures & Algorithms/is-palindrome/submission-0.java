class Solution {
    private boolean alphaNum(char c){
        return Character.isLetterOrDigit(c);
    }
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            while(left<right && !alphaNum(s.charAt(left))){
                left++;
            }
            while(left<right && !alphaNum(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
