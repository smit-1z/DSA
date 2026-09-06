class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int cDist = 0;
        int tDist = 0;

        for (int i = 0; i < distance.length; i++) {
            if (start < destination && (i >= start && i < destination)) {
                cDist += distance[i];
            }

            if (start > destination && (i >= start || i < destination)) {
                cDist += distance[i];
            }
            tDist+=distance[i];
        }

        return Math.min(tDist-cDist,cDist);
    }
}