class Solution {
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();

    Map<Integer,List<Integer>> map =new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int[] pre:prerequisites){
            map.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!visited.contains(i) && cycleFound(i)){
                return false;
            }
        }
        return true;
    }

    public boolean cycleFound(int num){
        if(visiting.contains(num)){
            return true;
        }
        visiting.add(num);

         for (int pre : map.getOrDefault(num, Collections.emptyList())) {
            if(!visited.contains(pre) && cycleFound(pre)){
                return true;
            }
        }

        visiting.remove(num);
        visited.add(num);
        return false;

    } 
}