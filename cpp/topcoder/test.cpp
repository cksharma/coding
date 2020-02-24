#include <bits/stdc++.h>
using namespace std;

ostream& operator<<(ostream& os, const vector<int>& v) {
    for (int item : v) os << item << ",";
    return os;
}

int main()
{
    vector<int> x1 (200), y1(200), x2, y2;
    iota(x1.begin(), x1.end(), 1);
    iota(y1.begin(), y1.end(), 1);
    
    for (int i = (int)1e9; i > (int)1e9 - 200; --i) {
        x2.push_back(i);
        y2.push_back(i);
    }
    
    for (int i = 0; i < 200; ++i) {
        int idx = rand() % 200;
        swap(x1[i], x1[idx]);
        swap(y1[i], y1[idx]);
        swap(x2[i], x2[idx]);
        swap(y2[i], y2[idx]);
    }
    
    cout << x1 << endl;
    cout << y1 << endl;
    cout << x2 << endl;
    cout << y2 << endl;
    
    cout << endl << endl;
    cout << "Size " << x1.size() << " Size " << x2.size() << endl;
}
