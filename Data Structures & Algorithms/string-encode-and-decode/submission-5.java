class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded=new StringBuilder();
        for(String str:strs){
            encoded.append(str);
            encoded.append('.');
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded=new ArrayList<>();
        StringBuilder newStr=new StringBuilder();
        for(char ch:str.toCharArray()){
            if(ch!='.'){
                newStr.append(ch);
            }else{
                decoded.add(newStr.toString());
                newStr.setLength(0);
            }
        }
        return decoded;
    }
}
