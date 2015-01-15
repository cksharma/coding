package medium;

import java.util.Arrays;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int start = 0, i = 0, runningCost = 0, totalGas = 0, totalCost = 0; 
		totalGas = Arrays.stream(gas).sum();
		totalCost = Arrays.stream(cost).sum();

		// for (int item : gas) totalGas += item;
		// for (int item : cost) totalCost += item;

		if (totalGas < totalCost)
			return -1;

		while (start > i || (start == 0 && i < gas.length)) {
			runningCost += gas[i];
			if (runningCost >= cost[i]) {
				runningCost -= cost[i++];
			} else {
				runningCost -= gas[i];
				if (--start < 0)
					start = gas.length - 1;
				runningCost += (gas[start] - cost[start]);
			}
		}
		return start;
	}

	public static void main(String[] args) {
		GasStation sol = new GasStation();
		int[] gas = new int[] { 10, 5, 7, 14, 9 };
		int[] cost = new int[] { 8, 5, 14, 3, 1 };
		System.out.println(sol.canCompleteCircuit(gas, cost));

		gas = new int[] { 10 };
		cost = new int[] { 8 };
		System.out.println(sol.canCompleteCircuit(gas, cost));
	}
}
