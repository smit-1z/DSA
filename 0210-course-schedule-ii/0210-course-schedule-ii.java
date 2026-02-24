class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    Map<Integer,Boolean> visiting = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         if(numCourses == 1) return new int[]{0};
        for(int i =0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }

        for(int[] preReq : prerequisites){
            map.get(preReq[0]).add(preReq[1]);
        }

        for(int i =0;i<numCourses;i++){
            boolean isPossible = dfs(i);
            if(!isPossible) return new int[0];
        }

        
    int[] returnArr = new int[result.size()];

       for(int i=0;i<result.size();i++){
        returnArr[i] = result.get(i);
       }

       return returnArr;
    }

    public boolean dfs(int course){
        if(visiting.containsKey(course)){
            return visiting.get(course);
        }

        visiting.put(course,false);
        for(int preReq:map.get(course)){
            if(!dfs(preReq)) return false;
        }
        result.add(course);
        visiting.put(course,true);
        return true;
    }
}