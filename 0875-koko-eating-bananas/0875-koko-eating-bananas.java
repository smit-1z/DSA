class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 0;
        int max = 0;
        int res = 0;

        for(int pile:piles){
            max = Math.max(max, pile);
        }
        

        while(min <= max){
            int mid = min + (max - min)/2;

            if(canKokoFinish(piles, h, mid)){
                max = mid-1;
                res = mid;
            }else{
                min = mid+1;
            }
        }

        return res;
    }

    public boolean canKokoFinish(int[] piles, int h, int k){
        int time = 0;
        for(int pile:piles){
            time += Math.ceil((double) pile/k);
        }
        return time <= h; 
    }
}