class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int size = intervals.length;
        int[] start = new int[size];
        int[] end = new int[size];

       for(int i=0;i<size;i++){
            int[] interval = intervals[i];
            start[i] = interval[0];
            end[i] = interval[1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int minRooms = 0;

        int i = 0;
        int j = 0;
        while(i < size){
            if(start[i] < end[j]){
                i++;
                rooms++;
            }else{
                j++;
                rooms--;
            }
            minRooms = Math.max(rooms,minRooms);
        }

        return minRooms;
    }
}