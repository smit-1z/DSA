class Solution {
    Map<Integer, List<Integer>> map;
    Set<Integer> visiting;
    Set<Integer> visited;

    

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.map = new HashMap<>();
        this.visiting = new HashSet<>();
        this.visited = new HashSet<>();


         for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }

        for (int[] preReqs : prerequisites) {
            map.get(preReqs[0]).add(preReqs[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (cycleFound(i)) {
                return false;
            }
        }
        return true;
    }

    public boolean cycleFound(int courseId) {
        if (visiting.contains(courseId))
            return true;
        if (visited.contains(courseId))
            return false;
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
/*
 [[1,0],[0,1]]

 {
    1 [0]
    0 [1]
 }
*/