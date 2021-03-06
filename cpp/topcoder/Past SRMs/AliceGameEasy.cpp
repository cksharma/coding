#include <bits/stdc++.h>
using namespace std;

class AliceGameEasy {
public:
	long long findMinimumValue(long long x, long long y) {
		long long ans = 0;
		long long total = 2LL * ( x + y );
		                                           
		long long n = 0LL;
		while(true) {
			long long sum = n * ( n + 1LL );
			if(sum == total) {
				break;
			} else if(sum > total ) {
				return -1;
			}
			++n;
		}
//		std::cout << "CKS " << n << std::endl;
		for(long long k = n; x > 0 &&  k >= 1; --k) {
			x -= k;
			ans++;	
		}
		return ans;
	}
};


// BEGIN KAWIGIEDIT TESTING
// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
bool KawigiEdit_RunTest(int testNum, long long p0, long long p1, bool hasAnswer, long long p2) {
	cout << "Test " << testNum << ": [" << p0 << "," << p1;
	cout << "]" << endl;
	AliceGameEasy *obj;
	long long answer;
	obj = new AliceGameEasy();
	clock_t startTime = clock();
	answer = obj->findMinimumValue(p0, p1);
	clock_t endTime = clock();
	delete obj;
	bool res;
	res = true;
	cout << "Time: " << double(endTime - startTime) / CLOCKS_PER_SEC << " seconds" << endl;
	if (hasAnswer) {
		cout << "Desired answer:" << endl;
		cout << "\t" << p2 << endl;
	}
	cout << "Your answer:" << endl;
	cout << "\t" << answer << endl;
	if (hasAnswer) {
		res = answer == p2;
	}
	if (!res) {
		cout << "DOESN'T MATCH!!!!" << endl;
	} else if (double(endTime - startTime) / CLOCKS_PER_SEC >= 2) {
		cout << "FAIL the timeout" << endl;
		res = false;
	} else if (hasAnswer) {
		cout << "Match :-)" << endl;
	} else {
		cout << "OK, but is it right?" << endl;
	}
	cout << "" << endl;
	return res;
}
int main() {
	bool all_right;
	all_right = true;
	
	long long p0;
	long long p1;
	long long p2;
	
	{
	// ----- test 0 -----
	p0 = 7ll;
	p1 = 14ll;
	p2 = 2ll;
	all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
	// ------------------
	}
	
	{
	// ----- test 1 -----
	p0 = 10ll;
	p1 = 0ll;
	p2 = 4ll;
	all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
	// ------------------
	}
	
	{
	// ----- test 2 -----
	p0 = 932599670050ll;
	p1 = 67400241741ll;
	p2 = 1047062ll;
	all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
	// ------------------
	}
	
	{
	// ----- test 3 -----
	p0 = 7ll;
	p1 = 13ll;
	p2 = -1ll;
	all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
	// ------------------
	}
	
	{
	// ----- test 4 -----
	p0 = 0ll;
	p1 = 0ll;
	p2 = 0ll;
	all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
	// ------------------
	}
	
	{
	// ----- test 5 -----
	p0 = 100000ll;
	p1 = 400500ll;
	p2 = 106ll;
	all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
	// ------------------
	}
	
	if (all_right) {
		cout << "You're a stud (at least on the example cases)!" << endl;
	} else {
		cout << "Some of the test cases had errors." << endl;
	}
	return 0;
}
// END KAWIGIEDIT TESTING
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
