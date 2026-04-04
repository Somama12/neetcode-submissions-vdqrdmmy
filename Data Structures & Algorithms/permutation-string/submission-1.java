class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i) - 'a']+=1;
            arr2[s2.charAt(i) - 'a']+=1;
        }
        for(int j=s1.length(); j< s2.length(); j++){
            if(Arrays.equals(arr1,arr2)){
                return true;
            }
            arr2[s2.charAt(j) - 'a']+=1;
            arr2[s2.charAt(j-s1.length()) - 'a']-=1;
        }
        return Arrays.equals(arr1,arr2);
    }
}
