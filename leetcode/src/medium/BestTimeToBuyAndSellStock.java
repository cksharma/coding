package medium;

public class BestTimeToBuyAndSellStock {
	
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int ans = 0;
		int buy = prices[0];
				
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < buy) {
				buy = prices[i];
			}
			if (prices[i] - buy > ans) {
				ans = prices[i] - buy;		
			}
		}
		return ans;
    }
	
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock sol = new BestTimeToBuyAndSellStock();
		int[] prices = new int[] {6, 7, 5, 7, 7, 10, 4, 8, 9, 14, 11, 2, 13};
		System.out.println(sol.maxProfit(prices));
	}
}
