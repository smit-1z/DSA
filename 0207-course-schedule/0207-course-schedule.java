class Solution {
    HashMap<Integer,Boolean> visiting = new HashMap<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] preReq : prerequisites) {
            int c = preReq[0];
            int p = preReq[1];
            map.get(c).add(p);
        }

        for (int i = 0; i < n; i++) {
            if (!visiting.containsKey(i) &&dfs(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int courseId) {
        if (visiting.containsKey(courseId)) {
           return visiting.get(courseId);
        }

        visiting.put(courseId,true);
        for (int pre : map.get(courseId)) {
           if(dfs(pre)){
            return true;
           }
        }
        visiting.put(courseId,false);
        return false;
    }
}