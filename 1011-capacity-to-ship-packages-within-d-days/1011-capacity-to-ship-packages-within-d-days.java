class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxLoad = 0;
        int minLoad = 0;

        for(int i=0;i<weights.length;i++){
            maxLoad+=weights[i];
            minLoad = Math.max(minLoad, weights[i]);
        }

       while(minLoad < maxLoad){
        int mid =minLoad + (maxLoad-minLoad)/2;
        if(canFit(mid, weights, days)){
            maxLoad = mid;
        }else{
            minLoad = mid+1;
        }
       } 
       return minLoad;
    }

    public boolean canFit(int load, int[] weights,int d){
        int days = 1;
        int currLoad = 0;

        for(int weight : weights){
            currLoad+=weight;
            if(currLoad > load){
                currLoad = weight;
                days++;
            }   
        }

        return days<=d;
    }
}
