// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class BestTimeToBuyAndSellStockSolution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int smallest = Integer.MAX_VALUE;

        for (int price : prices){
            if  (price < smallest){
                smallest = price; 
            }
            else {
                maxProfit = Math.max(maxProfit, price - smallest);
            }
        }
        return maxProfit; 
    }
}