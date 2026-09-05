class Solution {
    Set<Integer> visiting = new HashSet<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && foundCycle(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean foundCycle(int num) {
        if (visiting.contains(num)) {
            return true;
        }
        if(visited.contains(num)){
            return false;
        }

        visiting.add(num);

        for (int pre : map.get(num)) {
            if (foundCycle(pre)) {
                return true;
            }
        }

        visiting.remove(num);
        visited.add(num);
        return false;
    }
}