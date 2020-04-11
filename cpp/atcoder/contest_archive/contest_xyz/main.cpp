#include <bits/stdc++.h>
using namespace std;

int main() {
    cout << "Hello VSCode" << endl;
    map<int, int> mp = { { 1,  2}, {3 , 4}};
    cout << mp.size() << endl;
    for (const auto& [k, v] : mp) {
        cout << "CKS ka value " << v << endl;
    }
}
