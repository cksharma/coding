#include <bits/stdc++.h>
using namespace std;

int main()
{
    /*string str; cin >> str;
    string_view sv(str);
    cout << sv << endl;
    str = "Chandra Prasad";
    cout << sv << endl;*/

    string haha = "Chandra";
    string_view sv_haha(haha);
    haha[0] = 'H';
    cout << sv_haha << endl;

}