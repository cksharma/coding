package medium;

public class BestTimeToBuyAndSellStockII {
	
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int maxProfit = 0;
        int runningSum = 0;
        
        for (int i = 1; i < prices.length; i++) {
        	int diff = prices[i] - prices[i - 1];
        	runningSum += diff;
        	if (runningSum < 0) {
        		runningSum = 0;
        	}
        	if (diff >= 0) {
        		maxProfit += diff;
        	}
        }        
        return maxProfit;
    }
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockII sol = new BestTimeToBuyAndSellStockII();
		int[] prices = new int[] {6, 7, 5, 7, 7, 10, 4, 8, 9, 14, 11, 2, 13};
		System.out.println(sol.maxProfit(prices));
	}
}
