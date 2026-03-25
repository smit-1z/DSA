class Solution {
    Set<Integer> visiting;
    Set<Integer> visited;
    Map<Integer, List<Integer>> map;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.map = new HashMap<>();
        this.visited = new HashSet<>();
        this.visiting = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] preReq : prerequisites) {
            map.get(preReq[0]).add(preReq[1]);
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

        for (int preReq : map.get(courseId)) {
            if (cycleFound(preReq)) {
                return true;
            }
        }
        visiting.remove(courseId);
        visited.add(courseId);
        return false;
    }
}