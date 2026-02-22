class Solution {
    public int maxProfit(int[] prices) {
        int currentPrice = prices[0];
        int maxProfit = 0;

        for(int price:prices){
            if(price < currentPrice){
                currentPrice = price;
            }

            maxProfit = Math.max((price - currentPrice), maxProfit);
        }

        return maxProfit;
    }
}