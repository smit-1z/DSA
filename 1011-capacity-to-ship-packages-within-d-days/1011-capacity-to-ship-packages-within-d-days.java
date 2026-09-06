class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;

        for (int w : weights) {
            max += w;
            min = Math.max(w, min);
        }


     while (min < max){
            int mid = min + (max - min) / 2;
            if (canFit(weights, days, mid)) {
                max = mid ;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    public boolean canFit(int[] weights, int days, int capacity) {

        int weight = 0;
        int usedDays = 1;

        for (int w : weights) {
            if (weight + w > capacity) {
                usedDays++;
                weight = 0;
            }
            weight += w;
            if (usedDays > days) {
                return false;
            }
        }
        return true;

    }
}