class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int res[] = new int[k];
        int resIdx = 0;

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
            max = Math.max(max,map.get(num));
        }

        List<Integer>[] bucket = new List[max+1];

        for(int i=0;i<max+1;i++){
           bucket[i] = new ArrayList<>();
        }

        for(int key:map.keySet()){
            bucket[map.get(key)].add(key);
        }  
 
        for(int i = max ; i>=0 && k>0;i--){
            for(int num:bucket[i]){
                res[resIdx++] =num;
                k--;
            }
        }

        return res;
    }
}