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
        StringBuilder current=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='.'){
                decoded.add(current.toString());
                current.setLength(0);
            }else{
                current.append(str.charAt(i));
            }
        }
        return decoded;
    }
}
