#include <bits/stdc++.h>
using namespace std;

template<typename K, typename V>
void test(K key, V val) {
    cout << key << ", " << val << endl;
    return;
}

int main() {
    vector<int> v(100, 0);
    iota(v.begin(), v.end(), 0);
    for(int item : v ) cout << item << " "; cout << "\n";
    test("Chandra", "Kant");

    return 0;
}