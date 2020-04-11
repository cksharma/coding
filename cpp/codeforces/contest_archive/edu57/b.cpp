#include <bits/stdc++.h>
using namespace std;

long long sum (long long n, int sz) {
    long long kk = ((n + 1)*(n)) / 2;
    return kk;
}
const long long MD = 998244353;
int main()
{
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    cout.setf(ios::fixed); cout.precision(10);
    int n;
    cin >> n;
    string str;
    cin >> str;
    set<char> st;
    for(char ch : str ) st.insert( ch );
    int cnt = st.size();
    long long myLen = 1;
    long long ans = 1;
    for(int i = 1; i < str.size(); ++i) {
        if( str[i] == str[i - 1] ) myLen++;
        else {
            ans += sum(myLen, cnt);
            myLen = 1;
            ans %= MD;
        }
    }
    ans += sum(myLen, cnt);
    ans %= MD;
    ans /= (cnt - 1);
    cout << ans << endl;
}
