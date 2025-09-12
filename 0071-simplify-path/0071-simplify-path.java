class Solution {
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        int index = 0;

        for (String dir : dirs) {
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
            } else if (dir.equals("..")) {
                if(index>0) index--;
            } else {
                dirs[index++] = dir;
            }
        }
        if (index == 0)
            return "/";
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < index; i++) {
            res.append("/").append(dirs[i]);
        }

        return res.toString();
    }
}