class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;

        int[] res = new int[n];

        Arrays.fill(res, 1);

        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
            } else {
                int lake = rains[i];
                if (lastRain.containsKey(lake)) {

                    Integer dryDay = dryDays.higher(lastRain.get(lake));
                    if (dryDay == null) {
                        return new int[] {};
                    }
                    res[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                res[i] = -1;
                lastRain.put(lake, i);
            }
        }
        return res;
    }
}