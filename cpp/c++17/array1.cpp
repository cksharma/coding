#include <bits/stdc++.h>
using namespace std;

void array_test() {
    int arr1[3] = {1, 2, 3};
    vector<int*> v;
    cout << "CKS hee\n";
    v.push_back(new int[3]{1, 2, 3});
    cout << v.size() << endl;
    cout << "CKS size\n";
    shared_ptr<int[]> sp ( new int[3]{1, 2, 3});
    int* arr = sp.get();
    for (int i = 0; i < 3; ++i) cout << arr[i] << ", ";
    cout << endl;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    array_test();
}
