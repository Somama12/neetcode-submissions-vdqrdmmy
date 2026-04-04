class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        StringBuilder st=new StringBuilder();
        backtrack(0,0,n, st, res);
        return res;
    }
    public void backtrack(int open, int close, int n,  StringBuilder st, List<String> res){
        if(open==close && open==n){
            res.add(st.toString());
            return;
        }
        if(open<n){
            st.append('(');
            backtrack(open+1, close, n, st, res);
            st.deleteCharAt(st.length()-1);
        }
        if(close<open){
            st.append(')');
            backtrack(open, close+1, n,st, res);
            st.deleteCharAt(st.length()-1);
        }
    }

}