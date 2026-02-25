class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer,Integer> lastRain = new HashMap<>();
        int n = rains.length;
        int[] res= new int[n];
        TreeSet<Integer> dryDays = new TreeSet<>();

        for(int i=0;i<n;i++){
            if(rains[i] == 0){
                dryDays.add(i);
                res[i] = 1;
            }else{
                int lake = rains[i];
                if(lastRain.containsKey(lake)){
                    Integer dry = dryDays.higher(lastRain.get(lake));
                    if(dry == null){
                        return new int[]{};
                    }
                    res[dry] = lake;
                    dryDays.remove(dry);
                }
                res[i] = -1;
                lastRain.put(lake,i);
            }
        }
            return res;

    }
}