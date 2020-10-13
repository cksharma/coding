#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

struct State {
	int planet;
	int years;
	State(int p, int y) : planet(p), years(y) {}
};

class AlienOccupation {
public:
	vector <int> getInfo(int N, int A, vector <int> X, vector <int> Y) {
		queue<State> Q; Q.push({A, 0});
		unordered_set<int> visited; 
		visited.insert(A);
	
		unordered_map<int, int> oneYearMap; 
		oneYearMap[0] = 1;
		int T = 0, U = 0, V = 0;
		while (Q.size() > 0) {
			T = visited.size();
			const State& st = Q.front(); Q.pop();
			int p = st.planet;
			int y = st.years;

			for (int i = 0; i < X.size(); ++i) {
				int new_planet = (X[i] * (ll)p + Y[i]) % (ll)N;
				if (visited.find(new_planet) == visited.end()) {
					Q.push({new_planet, y + 1});
					visited.insert(new_planet);
					oneYearMap[y + 1]++;
					U = max(U, y + 1);
					V = max(V, oneYearMap[y + 1]);
				}
			}
			if (T == N) break;
		}
		return {T, U, V};
	}
};


// BEGIN KAWIGIEDIT TESTING
// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
bool KawigiEdit_RunTest(int testNum, int p0, int p1, vector <int> p2, vector <int> p3, bool hasAnswer, vector <int> p4) {
	cout << "Test " << testNum << ": [" << p0 << "," << p1 << "," << "{";
	for (int i = 0; int(p2.size()) > i; ++i) {
		if (i > 0) {
			cout << ",";
		}
		cout << p2[i];
	}
	cout << "}" << "," << "{";
	for (int i = 0; int(p3.size()) > i; ++i) {
		if (i > 0) {
			cout << ",";
		}
		cout << p3[i];
	}
	cout << "}";
	cout << "]" << endl;
	AlienOccupation *obj;
	vector <int> answer;
	obj = new AlienOccupation();
	clock_t startTime = clock();
	answer = obj->getInfo(p0, p1, p2, p3);
	clock_t endTime = clock();
	delete obj;
	bool res;
	res = true;
	cout << "Time: " << double(endTime - startTime) / CLOCKS_PER_SEC << " seconds" << endl;
	if (hasAnswer) {
		cout << "Desired answer:" << endl;
		cout << "\t" << "{";
		for (int i = 0; int(p4.size()) > i; ++i) {
			if (i > 0) {
				cout << ",";
			}
			cout << p4[i];
		}
		cout << "}" << endl;
	}
	cout << "Your answer:" << endl;
	cout << "\t" << "{";
	for (int i = 0; int(answer.size()) > i; ++i) {
		if (i > 0) {
			cout << ",";
		}
		cout << answer[i];
	}
	cout << "}" << endl;
	if (hasAnswer) {
		if (answer.size() != p4.size()) {
			res = false;
		} else {
			for (int i = 0; int(answer.size()) > i; ++i) {
				if (answer[i] != p4[i]) {
					res = false;
				}
			}
		}
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
	
	int p0;
	int p1;
	vector <int> p2;
	vector <int> p3;
	vector <int> p4;
	
	{
	// ----- test 0 -----
	p0 = 7;
	p1 = 4;
	int t2[] = {1};
			p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
	int t3[] = {1};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {7,6,1};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
	// ------------------
	}
	
	{
	// ----- test 1 -----
	p0 = 100;
	p1 = 47;
	int t2[] = {2,14,14};
			p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
	int t3[] = {10,2,4};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {51,5,20};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
	// ------------------
	}
	
	{
	// ----- test 2 -----
	p0 = 100;
	p1 = 47;
	int t2[] = {1,11};
			p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
	int t3[] = {0,30};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {1,0,0};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
	// ------------------
	}
	
	{
	// ----- test 3 -----
	p0 = 123456;
	p1 = 0;
	int t2[] = {3,4,55555};
			p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
	int t3[] = {6,7,88888};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {123456,20,18004};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
	// ------------------
	}
	
	{
	// ----- test 4 -----
	p0 = 230;
	p1 = 23;
	int t2[] = {2,2};
			p2.assign(t2, t2 + sizeof(t2) / sizeof(t2[0]));
	int t3[] = {0,0};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {5,4,1};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
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