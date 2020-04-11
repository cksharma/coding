#include "header.h"

int BestTimeToBuyAndSellStock::maxProfit(vector<int> &prices) {
	int ans = 0;
	int running_sum = 0;
	
	for (int i = 1; i < (int)prices.size(); i++) {
		int diff = prices[i] - prices[i - 1];
		running_sum += diff;
		if (running_sum < 0) {
			running_sum = 0;
		}	
		ans = max(ans, running_sum);
	}
	return ans;
}

