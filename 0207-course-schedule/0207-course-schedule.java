class Solution {
    Map<Integer,List<Integer>> map ;
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        this.map = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        for(int [] prerequisite : prerequisites){
            map.get(prerequisite[0]).add(prerequisite[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(findCycle(i)){
                return false;
            }
        }
        return true;
    }

    public boolean findCycle(int course){
        if(visited.contains(course)){
            return false;
        }
        if(visiting.contains(course)){
            return true;
        }

        visiting.add(course);

        for(int preReq: map.get(course)){
            if(findCycle(preReq)){
                return true;
            }
        }
        visiting.remove(course);
        visited.add(course);
        return false;
    }
}