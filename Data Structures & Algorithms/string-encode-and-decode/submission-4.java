class Solution {

    public String encode(List<String> strs) {
        StringBuilder str=new StringBuilder();
        for(String s:strs){
            str.append(s);
            str.append('.');
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> list=new ArrayList<>();
        StringBuilder newStr=new StringBuilder();
        for(char ch:str.toCharArray()){
            if(ch!='.'){
                newStr.append(ch);
            }else{
                list.add(newStr.toString());
                newStr.setLength(0);
            }
        }
        return list;
    }
}
