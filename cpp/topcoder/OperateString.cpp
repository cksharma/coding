#include <vector>
#include <list>
#include <map>
#include <set>
#include <queue>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

class OperateString
{
public:
	string operate(string s, vector<int> moves)
	{
		int n = s.size();
		long long sum = 0;
		for (int item : moves)
			sum += (long long)item;
		sum = sum % n;
		if (sum > 0)
		{
			string f = s.substr(0, sum);
			string l = s.substr(sum);
			return l + f;
		}
		else if (sum < 0)
		{
			int idx = s.size() + sum;
			string f = s.substr(0, idx);
			string l = s.substr(idx);
			return l + f;
		}
		return s;
	}
};

// BEGIN KAWIGIEDIT TESTING
// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
bool KawigiEdit_RunTest(int testNum, string p0, vector<int> p1, bool hasAnswer, string p2)
{
	cout << "Test " << testNum << ": ["
		 << "\"" << p0 << "\""
		 << ","
		 << "{";
	for (int i = 0; int(p1.size()) > i; ++i)
	{
		if (i > 0)
		{
			cout << ",";
		}
		cout << p1[i];
	}
	cout << "}";
	cout << "]" << endl;
	OperateString *obj;
	string answer;
	obj = new OperateString();
	clock_t startTime = clock();
	answer = obj->operate(p0, p1);
	clock_t endTime = clock();
	delete obj;
	bool res;
	res = true;
	cout << "Time: " << double(endTime - startTime) / CLOCKS_PER_SEC << " seconds" << endl;
	if (hasAnswer)
	{
		cout << "Desired answer:" << endl;
		cout << "\t"
			 << "\"" << p2 << "\"" << endl;
	}
	cout << "Your answer:" << endl;
	cout << "\t"
		 << "\"" << answer << "\"" << endl;
	if (hasAnswer)
	{
		res = answer == p2;
	}
	if (!res)
	{
		cout << "DOESN'T MATCH!!!!" << endl;
	}
	else if (double(endTime - startTime) / CLOCKS_PER_SEC >= 2)
	{
		cout << "FAIL the timeout" << endl;
		res = false;
	}
	else if (hasAnswer)
	{
		cout << "Match :-)" << endl;
	}
	else
	{
		cout << "OK, but is it right?" << endl;
	}
	cout << "" << endl;
	return res;
}
int main()
{
	bool all_right;
	all_right = true;

	string p0;
	vector<int> p1;
	string p2;

	{
		// ----- test 0 -----
		p0 = "abcde";
		int t1[] = {3};
		p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
		p2 = "deabc";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
	}

	{
		// ----- test 1 -----
		p0 = "abcde";
		int t1[] = {1, 2};
		p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
		p2 = "deabc";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
	}

	{
		// ----- test 2 -----
		p0 = "abracadabra";
		int t1[] = {-3};
		p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
		p2 = "braabracada";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
	}

	{
		// ----- test 3 -----
		p0 = "topcoder";
		int t1[] = {-5, 7, -2, 13};
		p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
		p2 = "dertopco";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
	}

	{
		// ----- test 4 -----
		p0 = "havefunsolvingthissrmwatchoutfortimeoutsmakesureyoursolutionisfastenough";
		int t1[] = {1000000000, -900000000, 800000000, -700000000, 600000000, 543210987};
		p1.assign(t1, t1 + sizeof(t1) / sizeof(t1[0]));
		p2 = "ingthissrmwatchoutfortimeoutsmakesureyoursolutionisfastenoughhavefunsolv";
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
	}

	if (all_right)
	{
		cout << "You're a stud (at least on the example cases)!" << endl;
	}
	else
	{
		cout << "Some of the test cases had errors." << endl;
	}
	return 0;
}
// END KAWIGIEDIT TESTING
//Powered by KawigiEdit 2.1.4 (beta) modified by pivanof!
