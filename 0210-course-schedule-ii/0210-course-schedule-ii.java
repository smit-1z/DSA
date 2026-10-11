class Solution {
    Map<Integer, List<Integer>> map;
    List<Integer> res = new ArrayList<>();
    Map<Integer, Boolean> visiting = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (cycleFound(i)) {
                return new int[] {};
            }
        }

        int[] resArray = new int[res.size()];

        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }

    public boolean cycleFound(int courseId) {
        if (visiting.containsKey(courseId)) {
            return visiting.get(courseId);
        }

        visiting.put(courseId,true);
        for (int pre : map.get(courseId)) {
            if (cycleFound(pre))
            return true;
        }

        visiting.put(courseId, false);
        res.add(courseId);
        return false;
    }
}