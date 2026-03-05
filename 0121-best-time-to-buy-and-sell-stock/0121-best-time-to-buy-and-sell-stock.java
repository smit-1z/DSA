class Solution {
    public int maxProfit(int[] prices) {
        int curr = Integer.MAX_VALUE;
        int maxPrice = 0;
        for(int price : prices){
            if(curr > price){
                curr = price;
            }
            maxPrice = Math.max(maxPrice, price - curr);
        }

        return maxPrice;
    }
}