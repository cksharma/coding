
#include <vector>
#include <map>
#include <algorithm>
#include <cmath>
#include <cstdio>
#include <string.h>
#include <set>
#include <climits>
#include <sstream>
#include <iostream>

using namespace std;

int main()
{
	int max_start = 0, max_end = 0, sum = 0, maxValue = 0;
	int a[] = {-3, 6, 2, 1, 7, -8, 13, 0};
	for(int i = 0; i < sizeof(a) / sizeof(a[0]); i++)
	{
		sum += a[i];
		if(sum < 0)
		{
			sum = 0;
			max_start = i;
		}
		if(maxValue < sum)
		{
			maxValue = sum;
			max_end = i;
		}
	}	
	for(int i = 0; i < max_start; i++)
	{
		sum += a[i];
		if(sum < 0)
			break;
		if(maxValue < sum)
		{
			maxValue = sum;
			max_end = i;
		}	
	}
	cout << maxValue << endl;
}
