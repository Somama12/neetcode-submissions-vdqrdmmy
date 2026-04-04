class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        boolean[] used = new boolean[strs.length];
      for(int i=0;i<strs.length;i++){
        if (used[i]) continue; 
        List<String> inner=new ArrayList<>();
        inner.add(strs[i]);
        used[i]=true;
        for(int j=i+1;j<strs.length;j++){
            if(!used[j] && anagram(strs[i],strs[j])){
                inner.add(strs[j]);
                used[j] = true;
            }
        }
        list.add(inner);
      } 
      return list; 
    }
    public static boolean anagram(String a, String b){
        if(a.length()!=b.length()) return false;
        int[] freq=new int[26];
        for(int i=0;i<a.length();i++){
            freq[a.charAt(i)-'a']++;
            freq[b.charAt(i)-'a']--;
        }
        for(int num:freq){
            if(num!=0) return false;
        }
        return true;
    }
}
