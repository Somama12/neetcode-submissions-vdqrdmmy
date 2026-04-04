class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String str : arr){
            if(str.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else if(str.equals(".") || str.equals("")){
                continue;
            }else{
                stack.push(str);
            }
        }

        if(stack.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        for(String dir : stack){
            res.append("/").append(dir);
        }
        return res.toString();
    }
}