class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int minCapacity = 0;
        int maxCapacity = 0;

        for (int w : weights) {
            minCapacity = Math.max(minCapacity, w);
            maxCapacity += w;
        }
        int res = maxCapacity;
        int mid = 0;

        while (minCapacity <= maxCapacity) {
            mid = minCapacity + (maxCapacity - minCapacity) / 2;
            if (canFit(weights, mid, days)) {
                res = mid;
                maxCapacity = mid - 1;
            } else {
                minCapacity = mid + 1;
            }
        }

        return res;
    }

    public boolean canFit(int[] weights, int capacity, int allowedDays) {
        int days = 1;
        int currWeight = 0;

        for (int w : weights) {
            if (currWeight + w > capacity) {
                days++;
                currWeight = 0;
            }
            currWeight+=w;
            if(days>allowedDays){
                return false;
            }
        }

        return true;
    }
}