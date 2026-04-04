class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> subString=new ArrayList<>();
        backtrack(res, subString, 0, s);
        return res;
    }
    public void backtrack(List<List<String>> res, List<String> subString, int index, String s){
        if(index>=s.length()){
            res.add(new ArrayList<>(subString));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(index, i, s)){
                subString.add(s.substring(index, i+1));
                backtrack(res, subString, i+1, s);
                subString.remove(subString.size()-1);
            }
        }
    }
    public boolean isPalindrome(int index, int i, String s){
        while(index<i){
            if(s.charAt(index)!=s.charAt(i)){
                return false;
            }
            index++;
            i--;
        }
        return true;
    }
}