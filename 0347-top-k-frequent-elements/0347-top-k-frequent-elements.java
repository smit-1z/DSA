class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }

        List<Integer>[] buckets = new List[max + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int key : map.keySet()) {
            buckets[map.get(key)].add(key);
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
           for(int key:buckets[i]){
            res[index++] = key;
           }
        }       
        
        return res;
    }
}