class Solution {
    private String[] map;
    private List<String> res;
    public List<String> letterCombinations(String digits) {
       
       map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        res=new ArrayList<>();
         if(digits.isEmpty()) return res;
        backtrack(0,new StringBuilder(), digits);
        return res;
    }
    public void backtrack(int i, StringBuilder str, String digits){
        if(str.length()==digits.length()){
            res.add(str.toString());
            return;
        }
        String chars=map[digits.charAt(i)-'0'];
        for(char ch: chars.toCharArray()){
             str.append(ch);
            backtrack(i+1, str, digits);
            str.deleteCharAt(str.length() - 1);
        }
    }
}
