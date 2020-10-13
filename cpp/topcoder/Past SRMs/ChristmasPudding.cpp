#include <bits/stdc++.h>
using namespace std;

struct Pudding {
    long long v;
    long long t;

    bool operator<(const Pudding& rhs) const {
        if (t != rhs.t) return t < rhs.t;
        return v < rhs.v;
    }
};

class ChristmasPudding {
public:
	long long eat(int N, long long Vall, long long Vsweet, vector <int> Vprefix, vector <int> Tprefix, vector <int> Sprefix, int seed) {
        long long state = seed;
        vector<long long> V, T, S;
        for (int i = 0; i < Vprefix.size(); ++i) {
            V.push_back(Vprefix[i]);
            T.push_back(Tprefix[i]);
            S.push_back(Sprefix[i]);
        }
	    while (V.size() < N) {
            state = (state * 1103515245 + 12345) % (long long)pow(2, 31);
            V.push_back(1 + (state % 1000000 ));
            state = (state * 1103515245 + 12345) % (long long)pow(2, 31);
            T.push_back( 1 + (state % 1000000) );
            state = (state * 1103515245 + 12345) % (long long)pow(2, 31);
            S.push_back( (state / 1024) % 2 );
        }
        vector<Pudding> sweet;
	    vector<Pudding> sour;
	    for (int i = 0; i < V.size(); ++i) {
	        long long v = V[i];
	        long long t = T[i];
	        long long s = S[i];
	        if (s % 2 == 0) sour.push_back({v, t});
	        else sweet.push_back({v, t});
	    }
        sort(sweet.rbegin(), sweet.rend());
	    sort(sour.rbegin(), sour.rend());
	    long long result = 0;

	        // Get the required amount of sweets
            for (int i = 0; i < sweet.size() && Vsweet > 0; ++i) {
                long long qty = min(Vsweet, sweet[i].v);
                result += qty * sweet[i].t;
                Vsweet -= qty;
                Vall -= qty;
                sweet[i].v -= qty;
            }
            Vsweet = 0;

            sort(sweet.rbegin(), sweet.rend());

            int swi = 0, soi = 0;
            while (swi < sweet.size() && soi < sour.size() && Vall > 0)
            {
                long long swt = sweet[swi].t;
                long long sot = sour[soi].t;
                if (swt > sot) {
                    long long qty = min(Vall, sweet[swi].v);
                    result += qty * swt;
                    Vall = Vall - qty;
                    swi++;
                }
                else {
                    long long qty = min(Vall, sour[soi].v);
                    result += qty * sot;
                    Vall = Vall - qty;
                    soi++;
                }
            }
            while (swi < sweet.size() && Vall > 0)
            {
                long long swt = sweet[swi].t;
                long long qty = min(Vall, sweet[swi].v);
                result += qty * swt;
                Vall = Vall - qty;
                swi++;
            }
            while (soi < sour.size() && Vall > 0)
            {
                long long sot = sour[soi].t;
                long long qty = min(Vall, sour[soi].v);
                result += qty * sot;
                Vall = Vall - qty;
                soi++;
            }

	    return result;
	}
};


// BEGIN KAWIGIEDIT TESTING
// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
bool KawigiEdit_RunTest(int testNum, int p0, long long p1, long long p2, vector <int> p3, vector <int> p4, vector <int> p5, int p6, bool hasAnswer, long long p7) {
	cout << "Test " << testNum << ": [" << p0 << "," << p1 << "," << p2 << "," << "{";
	for (int i = 0; int(p3.size()) > i; ++i) {
		if (i > 0) {
			cout << ",";
		}
		cout << p3[i];
	}
	cout << "}" << "," << "{";
	for (int i = 0; int(p4.size()) > i; ++i) {
		if (i > 0) {
			cout << ",";
		}
		cout << p4[i];
	}
	cout << "}" << "," << "{";
	for (int i = 0; int(p5.size()) > i; ++i) {
		if (i > 0) {
			cout << ",";
		}
		cout << p5[i];
	}
	cout << "}" << "," << p6;
	cout << "]" << endl;
	ChristmasPudding *obj;
	long long answer;
	obj = new ChristmasPudding();
	clock_t startTime = clock();
	answer = obj->eat(p0, p1, p2, p3, p4, p5, p6);
	clock_t endTime = clock();
	delete obj;
	bool res;
	res = true;
	cout << "Time: " << double(endTime - startTime) / CLOCKS_PER_SEC << " seconds" << endl;
	if (hasAnswer) {
		cout << "Desired answer:" << endl;
		cout << "\t" << p7 << endl;
	}
	cout << "Your answer:" << endl;
	cout << "\t" << answer << endl;
	if (hasAnswer) {
		res = answer == p7;
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
	long long p1;
	long long p2;
	vector <int> p3;
	vector <int> p4;
	vector <int> p5;
	int p6;
	long long p7;

	{
	// ----- test 0 -----
	p0 = 3;
	p1 = 300ll;
	p2 = 220ll;
	int t3[] = {100,100,200};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {4,5,7};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	int t5[] = {1,0,1};
			p5.assign(t5, t5 + sizeof(t5) / sizeof(t5[0]));
	p6 = 47;
	p7 = 1880ll;
	all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
	// ------------------
	}

	{
	// ----- test 1 -----
	p0 = 3;
	p1 = 390ll;
	p2 = 220ll;
	int t3[] = {100,100,200};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {4,5,7};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	int t5[] = {1,0,1};
			p5.assign(t5, t5 + sizeof(t5) / sizeof(t5[0]));
	p6 = 4747;
	p7 = 2260ll;
	all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
	// ------------------
	}

	{
	// ----- test 2 -----
	p0 = 3;
	p1 = 300ll;
	p2 = 300ll;
	int t3[] = {100,200,300};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {30,10,20};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	int t5[] = {0,1,0};
			p5.assign(t5, t5 + sizeof(t5) / sizeof(t5[0]));
	p6 = 42;
	p7 = 5000ll;
	all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
	// ------------------
	}

	{
	// ----- test 3 -----
	p0 = 2;
	p1 = 100ll;
	p2 = 0ll;
	int t3[] = {47,10};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {3,5};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	int t5[] = {0,0};
			p5.assign(t5, t5 + sizeof(t5) / sizeof(t5[0]));
	p6 = 5;
	p7 = 191ll;
	all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
	// ------------------
	}

	{
	// ----- test 4 -----
	p0 = 20;
	p1 = 5000000ll;
	p2 = 3000000ll;
	int t3[] = {470};
			p3.assign(t3, t3 + sizeof(t3) / sizeof(t3[0]));
	int t4[] = {407};
			p4.assign(t4, t4 + sizeof(t4) / sizeof(t4[0]));
	int t5[] = {0};
			p5.assign(t5, t5 + sizeof(t5) / sizeof(t5[0]));
	p6 = 4747;
	p7 = 3528114042726ll;
	all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
	// ------------------
	}

	{
	// ----- test 5 -----
	p0 = 10;
	p1 = 0ll;
	p2 = 0ll;
	p3.clear() /*{}*/;
	p4.clear() /*{}*/;
	p5.clear() /*{}*/;
	p6 = 0;
	p7 = 0ll;
	all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, p4, p5, p6, true, p7) && all_right;
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