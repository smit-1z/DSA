class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, map.get(nums[i]));
        }
        List<Integer>[] buckets = new List[max + 1];

        for (int i = 0; i <= max; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int key : map.keySet()) {
            buckets[map.get(key)].add(key);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = max; i >= 0 &&index < k; i--) {
            for (int num : buckets[i]) {
                    res[index++] = num;
                    if(index == k) return res;
                }
        }return res;
}}