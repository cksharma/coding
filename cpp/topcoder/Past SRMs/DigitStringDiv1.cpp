#include <bits/stdc++.h>
using namespace std;

vector<int> digits;
string S;
long long ans;

class DigitStringDiv1 {
public:    
    void populateDigits(int temp) {
        while( temp > 0 ) {
            digits.push_back( temp % 10 );
            temp /= 10;
        }
        reverse(digits.begin(), digits.end());
    }
    
    bool ok(vector<int>& runningVec) {
        if( runningVec.size() != digits.size() ) return runningVec.size() > digits.size();
        for(int i = 0; i < runningVec.size(); ++i) {
            if( runningVec[i] != digits[i] ) return runningVec[i] > digits[i];
        }
        return false;
    }
    
    void printvec(vector<int>& v) {
        for(int item : v ) cout << item << ", ";
    }
    
    void computeWithIndex( int si, vector<int>& runningVec) {
        if ( ok( runningVec) ) {
            long long remLen = S.length() - si - 1;
            ans += (1LL << remLen);
            //printvec(runningVec);
            return;
        }      
        
        for(int j = si + 1; j < S.length(); ++j) {
            runningVec.push_back( S[j] - '0');
            computeWithIndex( j, runningVec );
            runningVec.pop_back();            
        }        
    }
    
    long long count(string S1, int X) {
        ans = 0;        
        S = S1;
        digits.clear();
        populateDigits( X );
        
        for(int si = 0; si < S.size(); ++si) {
            if( S[si] == '0') continue;
            vector<int> runningVec; runningVec.push_back( S[si] - '0');
            computeWithIndex(si, runningVec);         
        }

        return ans;        
    }
};


// BEGIN KAWIGIEDIT TESTING
// Generated by KawigiEdit 2.1.4 (beta) modified by pivanof
bool KawigiEdit_RunTest(int testNum, string p0, int p1, bool hasAnswer, long long p2) {
    cout << "Test " << testNum << ": [" << "\"" << p0 << "\"" << "," << p1;
    cout << "]" << endl;
    DigitStringDiv1 *obj;
    long long answer;
    obj = new DigitStringDiv1();
    clock_t startTime = clock();
    answer = obj->count(p0, p1);
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
    
    string p0;
    int p1;
    long long p2;
    
    {
    // ----- test 0 -----
    p0 = "0";
    p1 = 1;
    p2 = 0ll;
    all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
    // ------------------
    }
    
    {
    // ----- test 1 -----
    p0 = "101";
    p1 = 9;
    p2 = 3ll;
    all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
    // ------------------
    }
    
    {
    // ----- test 2 -----
    p0 = "471";
    p1 = 47;
    p2 = 2ll;
    all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
    // ------------------
    }
    
    {
    // ----- test 3 -----
    p0 = "2222";
    p1 = 97;
    p2 = 5ll;
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
    // ------------------
    }

    {
    // ----- test 3 -----
    
    p0 = "12345678912345678912345678912345678912345678912";
    p1 = 12345;
    p2 = 5ll;
    all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
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
