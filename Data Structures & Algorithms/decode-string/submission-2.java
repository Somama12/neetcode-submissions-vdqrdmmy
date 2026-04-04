class Solution {
    int i=0;
    public String decodeString(String s) {
        StringBuilder str = new StringBuilder();
        int k = 0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                k = k*10 + (ch - '0');
            }else if(ch=='['){
                i++;
                String newStr = decodeString(s);
                while(k>0){
                    str.append(newStr);
                    k--;
                }
            }else if(ch==']'){
                return str.toString();
            }else{
                str.append(ch);
            }
            i++;
        }
        return str.toString();
    }
}