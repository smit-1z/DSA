class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;

        int res = max;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canFinish(mid, piles, h)) {
                res = mid;
                max = mid-1;
            } else {
                min = mid + 1;
            }
        }

        return res;
    }

    public boolean canFinish(int speed, int[] piles, int hours) {
        int usedHours = 0;
        for (int num : piles) {
            usedHours += Math.ceilDiv(num, speed);
            if (usedHours > hours)
                return false;
        }
        return usedHours <= hours;
    }
}