#include "header.h"

int GasStation::canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
	int start = 0;
    int i = 0;
    int runningCost = 0;
    
    int totalGas = accumulate(gas.begin(), gas.end(), 0);
    int totalCost = accumulate(cost.begin(), cost.end(), 0);
    
    if (totalGas < totalCost)
    	return -1;
    
    while (start > i || (start == 0 && i < gas.size())) {
    	runningCost += gas[i];
    	if (runningCost >= cost[i]) {
    		runningCost -= cost[i++];
    	} else {
    		runningCost -= gas[i];
    		if (--start < 0) 
    			start = gas.size() - 1;
    		runningCost += (gas[start] - cost[start]);
    	}        	
    }
    return start;        
}