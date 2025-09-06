class Solution {
    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];

        for(int i=0;i<nums.length;i++){
            numbers[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numbers,(a,b) -> (b+a).compareTo(a+b));
        if(numbers[0].equals("0")) return "0";

        StringBuilder res = new StringBuilder();

        for(String num:numbers){
            res.append(num);
        }

        return res.toString();
    }
}