class Solution {
    Map<Integer,Boolean> visiting = new HashMap<>();
    List<Integer> result = new ArrayList<>();
    Map<Integer,List<Integer>> preReqs = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            preReqs.put(i,new ArrayList<>());
        }

        for(int[] preReq : prerequisites){
            preReqs.get(preReq[0]).add(preReq[1]);
        }

        for(int i =0;i<numCourses;i++){
            if(!findCycle(i)){
                return new int[]{};
            }
        }

        int[] resArray = new int[result.size()];

        for(int i=0;i<resArray.length;i++){
            resArray[i] = result.get(i);
        }

        return resArray;
    }

    public boolean findCycle(int courseId){
        if(visiting.containsKey(courseId)){
            return visiting.get(courseId);
        }

        visiting.put(courseId,false);
        for(int preReq:preReqs.get(courseId)){
            if(!findCycle(preReq)){
                return false;
            }
        }

        visiting.put(courseId,true);
        result.add(courseId);
        return true;
    }
}
