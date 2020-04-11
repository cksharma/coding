#include <bits/stdc++.h>
using namespace std;

int main()
{
    string input;
    cin >> input;
    vector<int> ans(input.size(), 0);

    char ch = 'b';
    for(int i = input.size() - 1; i >= 0; --i) {
        if( input[i] != ch ) {
            ans[i] = 1;
            ch = ( ch == 'a' ? 'b' : 'a' );
        }
    }
    for(int item : ans) cout << item << " ";
    cout << "\n";
    return 0;
}
