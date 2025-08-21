class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> nums_lst = new ArrayList<>();
        
        for(int num: nums)
            nums_lst.add(num);
        
        getPermutations(nums_lst,permutations,0);
        return permutations;
    }
    
    public void getPermutations(List<Integer> list,List<List<Integer>> output, int index){
        if(index == list.size()) output.add(new ArrayList(list));
        
        for(int i=index;i<list.size();i++){
           Collections.swap(list,index,i);
           getPermutations(list, output, index + 1);
           Collections.swap(list, index, i);
        }
    }
}

