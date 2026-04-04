class Solution {
    private int i;
    public String decodeString(String s) {
        return helper(s);
    }
    public String helper(String s){
        StringBuilder res=new StringBuilder();
        int k=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                k=k*10+(c-'0');
            }else if(c=='['){
                i++;
                String subRes=helper(s);
                while(k-->0) res.append(subRes);
                k=0;
            }else if(c==']'){
                return res.toString();
            }else{
                res.append(c);
            }
            i++;
        }
        return res.toString();
    }
}