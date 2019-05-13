#include <bits/stdc++.h>
using namespace std;

string ans[12] = {
        "x^y^z",
        "x^z^y",
        "(x^y)^z",
        "(x^z)^y",
        "y^x^z",
        "y^z^x",
        "(y^x)^z",
        "(y^z)^x",
        "z^x^y",
        "z^y^x",
        "(z^x)^y",
        "(z^y)^x"
};

int main() {
    long double x, y, z;
    cin >> x >> y >> z;

    array<long double, 12> arr;
    arr[0] = log(x) * pow(y, z);
    arr[1] = log(x) * pow(z, y);
    arr[2] = log(x) * (z * y);
    arr[3] = log(x) * (y * z);

    arr[4] = log(y) * pow(x, z);
    arr[5] = log(y) * pow(z, x);
    arr[6] = log(y) * (z * x);
    arr[7] = log(y) * (x * z);

    arr[8] = log(z) * pow(x, y);
    arr[9] = log(z) * pow(y, x);
    arr[10] = log(z) * (x * y);
    arr[11] = log(z) * (y * x);

    long double res = INT_MIN;
    int index = 0;
    for (int i = 0; i < 12; i++) {
        if (arr[i] > res) {
            index = i;
            res = arr[i];
        }
        cout << arr[i] << " ";
    }
    cout << endl << endl;
    cout << ans[index] << endl;
}
