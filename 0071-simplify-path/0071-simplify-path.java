class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] dirs = path.split("/");

        for(String dir: dirs){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            }else if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(dir);
            }
        }
        if(stack.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        for(String str : stack){
            res.append("/").append(str);
        }

        return res.toString();
    }
}