class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] preReq : prerequisites) {
            int course = preReq[0];
            int pre = preReq[1];
            map.get(course).add(pre);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && cycleFound(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean cycleFound(int courseId) {
        if (visiting.contains(courseId)) {
            return true;
        }

        if (visited.contains(courseId)) {
            return false;
        }
        visiting.add(courseId);
        for (int pre : map.get(courseId)) {
            if (cycleFound(pre)) {
                return true;
            }
        }
        visiting.remove(courseId);
        visited.add(courseId);
        return false;
    }
}