class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;

        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int res = max;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canKokoEat(piles, mid, h)) {
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    public boolean canKokoEat(int[] piles, int speed, int hours) {
        int usedHours = 0;

        for (int pile : piles) {
            usedHours += Math.ceilDiv(pile, speed);
            if (usedHours > hours) {
                return false;
            }
        }
        return true;
    }
}