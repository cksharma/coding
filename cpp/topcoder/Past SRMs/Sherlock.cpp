#include <bits/stdc++.h>
using namespace std;

class Sherlock {
public:
	const string name[2] = {"BENEDICT", "CUMBERBATCH"};
	string someone = "It is someone else";
	string him = "It is him";

	bool ok(string& firstname, const string& referencename, int similarity)
	{
		int cnt = 0;
		for (char ch : firstname) {
			if (find(referencename.begin(), referencename.end(), ch) != referencename.end()) cnt++;
		}
		return cnt >= similarity;
	}

	string isItHim(string firstName, string lastName) {
		if (firstName.length() < 7 || lastName.length() < 7) return someone;
		if (firstName[0] != 'B' || lastName[0] != 'C') return someone;
		return ok(firstName, name[0], 3) && ok(lastName, name[1], 5) ? him : someone;
	}
};


// BEGIN KAWIGIEDIT TESTING
// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
bool KawigiEdit_RunTest(int testNum, string p0, string p1, bool hasAnswer, string p2) {
	cout << "Test " << testNum << ": [" << "\"" << p0 << "\"" << "," << "\"" << p1 << "\"";
	cout << "]" << endl;
	Sherlock *obj;
	string answer;
	obj = new Sherlock();
	clock_t startTime = clock();
	answer = obj->isItHim(p0, p1);
	clock_t endTime = clock();
	delete obj;
	bool res;
	res = true;
	cout << "Time: " << double(endTime - startTime) / CLOCKS_PER_SEC << " seconds" << endl;
	if (hasAnswer) {
		cout << "Desired answer:" << endl;
		cout << "\t" << "\"" << p2 << "\"" << endl;
	}
	cout << "Your answer:" << endl;
	cout << "\t" << "\"" << answer << "\"" << endl;
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

	string p0;
	string p1;
	string p2;

	{
	// ----- test 0 -----
	p0 = "BENEDICT";
	p1 = "CUMBERBATCH";
	p2 = "It is him";
	all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
	// ------------------
	}

	{
	// ----- test 1 -----
	p0 = "BENADRYL";
	p1 = "CUCUMBERPATCH";
	p2 = "It is him";
	all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
	// ------------------
	}

	{
	// ----- test 2 -----
	p0 = "HARSHIT";
	p1 = "MEHTA";
	p2 = "It is someone else";
	all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
	// ------------------
	}

	{
	// ----- test 3 -----
	p0 = "BATAXXAT";
	p1 = "CURMUDGEON";
	p2 = "It is him";
	all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
	// ------------------
	}

	{
	// ----- test 4 -----
	p0 = "BENEDI";
	p1 = "CUMBER";
	p2 = "It is someone else";
	all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
	// ------------------
	}

	{
	// ----- test 5 -----
	p0 = "BAXAXAXY";
	p1 = "CENTRIFUGAL";
	p2 = "It is someone else";
	all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
	// ------------------
	}

	{
	// ----- test 6 -----
	p0 = "BUMBLESHACK";
	p1 = "CRUMPLEHORN";
	p2 = "It is him";
	all_right = KawigiEdit_RunTest(6, p0, p1, true, p2) && all_right;
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
