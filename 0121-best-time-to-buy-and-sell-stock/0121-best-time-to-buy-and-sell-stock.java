class Solution {
    public int maxProfit(int[] prices) {
        int curr = prices[0];
        int maxProfit = 0;

        for(int price:prices){
            if(curr > price){
                curr = price;
            }
            maxProfit = Math.max((price - curr), maxProfit);
        }

        return maxProfit;
    }
}