class Solution {
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    Map<Integer,List<Integer>> map = new HashMap<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i =0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }

        for(int [] pre:prerequisites){
            int course = pre[0];
            int preReq = pre[1];
            map.get(course).add(preReq);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited.contains(i) && cycleFound(i)){
                return false;
            }
        }

        return true;
    }

    public boolean cycleFound(int courseId){
        if(visiting.contains(courseId)){
            return true;
        }
        if(visited.contains(courseId)){
            return false;
        }

        visiting.add(courseId);

        for(int pre: map.get(courseId)){
            if(!visited.contains(pre) && cycleFound(pre)){
                return true;
            }
        }

        visiting.remove(courseId);
        visited.add(courseId);
        return false;
    }
}