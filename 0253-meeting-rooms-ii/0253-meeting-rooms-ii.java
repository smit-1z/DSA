class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int rooms = 0;
        int maxRooms = 0;

        int[] start = new int[n];
        int[] end = new int[n];
        int pos = 0;
        for(int [] interval:intervals){
            start[pos] = interval[0];
            end[pos] = interval[1];
            pos++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i =0;
        int j = 0;
        int startTime = 0;
        int endTime = 0;

        while(i<n){
            startTime = start[i];
            endTime = end[j];

            if(startTime < endTime){
                rooms++;
                i++;
            }else{
                rooms--;
                j++;
            }
            maxRooms = Math.max(rooms,maxRooms);
        }

        return maxRooms;
    }
}