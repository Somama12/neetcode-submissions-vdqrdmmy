class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        char[] sort1=s1.toCharArray();
        Arrays.sort(sort1);
        for(int i=0;i<s2.length();i++){
            for(int j=i;j<s2.length();j++){
                String sub=s2.substring(i,j+1);
                char[] sort2=sub.toCharArray();
                Arrays.sort(sort2);
                if(Arrays.equals(sort1,sort2)){
                    return true;
                }
            }
        }
        return false;
    }
}
