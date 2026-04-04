class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s : paths) {
            if (s.equals("") || s.equals(".")) continue;
            else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }
        }

        if (stack.isEmpty()) return "/"; 

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        return sb.toString();
    }
}
