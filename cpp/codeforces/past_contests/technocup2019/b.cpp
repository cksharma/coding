#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    string str;
    cin >> str;
    vector<string> ans;
    int len = str.length();

    int row = 1, col = 1; bool found = false; int extra = 0;

    for(; row <= 5; row++) {
        for(col = 1; col <= 20; col++) {
            if( row * col >= len ) {
                found = true;
                extra = row * col - len;
                break;
            }
        }
        if(found) break;
    }

    //cout << "CKS " << row << ", " << col << " LEN " << len << endl;
    int index = 0;
    for(int i = 0; i < row && index < len; i++) {
        string s;
        if( extra > 0) {
            s = str.substr(index, col - 1) + "*";
            index += col - 1;
            extra--;
        } else {
            s = str.substr(index, col);
            index += col;
        }
        ans.push_back( s );
    }

    cout << ans.size() << " " << ans[0].size() << endl;
    for(auto& item : ans) {
        cout << item << endl;
    }
}