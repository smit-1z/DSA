
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        int max = 0;

        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            max = Math.max(max, freqMap.get(num));
        }

        List<Integer>[] buckets = new List[max+1];

        for(int i=0;i<=max;i++){
            buckets[i] = new ArrayList<>();
        }

        for(int key:freqMap.keySet()){
            int freq = freqMap.get(key);
            buckets[freq].add(key);
        }

        int index = 0;
        int[] result = new int[k];

        for(int i = buckets.length -1; i>=0 && index < k;i--){
            for(int num:buckets[i]){
                result[index++] = num;
            }
        }
        return result;

    }
}