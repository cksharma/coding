#include <iostream>
#include <algorithm>
using namespace std;
int desired; int P[8] = {0};
int A[8];

void SumOfSubsets(int curSum, int remSum, int index)
{
	P[index] = 1;
	if(curSum + A[index] == desired)
	{
		for(int i = 0; i <= index; i++) if(P[i]) cout << A[i] << "  ";
		cout << endl;
	}
	else if(curSum + A[index] + A[index + 1] <= desired)
	{
		SumOfSubsets(curSum + A[index], remSum - A[index], index + 1);
	}
	if(curSum + remSum - A[index] >= desired && curSum + A[index + 1] <= desired)
	{
		P[index] = 0;
		SumOfSubsets(curSum, remSum - A[index], index + 1);
	}
}

int main()
{	
	/*desired = 9; int sum = 0;
	for(int i = 0; i < 8; i++) A[i] = i + 1;
	for(int i = 0; i < 8; i++) P[i] = 0;
	for(int i = 0; i < 8;i++) sum += A[i];
	//cout << sum << desired << "  ";
	SumOfSubsets(0, sum, 0);*/
	cout << "Computed" << endl;	
}