class Solution {
    static boolean isChar(Character ch){
        return Character.isLetterOrDigit(ch);
    }
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<right){
            while(left<right && !isChar(s.charAt(left))){
                left++;
            }
            while(left<right && !isChar(s.charAt(right))){
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
