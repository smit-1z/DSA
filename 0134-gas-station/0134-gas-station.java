class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int diff = 0;

        for(int i=0;i<gas.length;i++){
            diff += gas[i] - cost[i];
            total += gas[i] - cost[i];
        
            if(diff < 0){
                start = i + 1;
                diff = 0;
            }
        }

        return total>=0 ? start: -1;
    }
}