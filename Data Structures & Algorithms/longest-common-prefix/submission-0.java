class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prev=strs[0];
        for(int i=0;i<strs.length;i++){
            while(!strs[i].startsWith(prev)){
                prev=prev.substring(0,prev.length()-1);
            }
            if(prev=="") return "";
        }
        return prev;
    }
}