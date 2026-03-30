class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minDifference = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=1;i<arr.length;i++){
            int diff = arr[i] - arr[i-1] ;
            if(diff == minDifference){
                res.add(Arrays.asList(arr[i-1],arr[i]));
            }else if(diff < minDifference){
                res.clear();
                minDifference = diff;
                res.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return res;
    }
}