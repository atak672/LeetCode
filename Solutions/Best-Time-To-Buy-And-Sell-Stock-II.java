// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii

class BestTimeToBuyAndSellStockIISolution {
    public int maxProfit(int[] prices) {

        // Utilizing peak and valley approach in one pass

        int maxProfit = 0; 

        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i + 1] >= prices[i]){
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit; 
        
    }
}