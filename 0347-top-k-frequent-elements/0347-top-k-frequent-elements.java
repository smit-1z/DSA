class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(num));
        }

        List<Integer>[] buckets = new List[maxFreq + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Integer key : freqMap.keySet()) {
            buckets[freqMap.get(key)].add(key);
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int num : buckets[i]) {
                if (index == k)
                    return res;
                res[index++] = num;
            }
        }
        return res;
    }
}
/*

{
    1 3
    2 2 
    3 1 
}

maxfreq = 3 + 1

[ [1] [2] [1] ]

*/