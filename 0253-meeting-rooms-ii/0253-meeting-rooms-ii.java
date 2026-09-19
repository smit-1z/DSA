class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int size = intervals.length;
        int[] start = new int[size];
        int[] end = new int[size];

        for (int i = 0; i < size; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int roomsInUse = 0;
        int minRooms = 0;

        int i = 0;
        int j = 0;
        while (i < size) {
            if (start[i] < end[j]) {
                i++;
                roomsInUse++;
            } else {
                j++;
                roomsInUse--;
            }
            minRooms = Math.max(roomsInUse, minRooms);
        }

        return minRooms;

    }
}