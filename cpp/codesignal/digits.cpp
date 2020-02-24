#include <bits/stdc++.h>
using namespace std;

int pagesNumberingWithInk(int current, int numberOfDigits) {
    int d = floor(log10(current) + 1);
    int ans = 0, original = current;
    for (int i = d; numberOfDigits >= i; ++i) {
        if (i == d) {
            int digits_cnt = ((int)pow(10, d) - original) * d;
            int cks = min(digits_cnt / d, numberOfDigits / d);
            numberOfDigits -= cks * d;
            ans += cks;
        } else {
            d = i;
            current = (int)pow(10, d);
            int digits_cnt = ((int)pow(10, d + 1) - current) * d;
            int cks = min(digits_cnt / d, numberOfDigits / d);
            numberOfDigits -= cks * d;
            ans += cks;
        }
    }
    return ans + (original - 1); // I am computing for original too.
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    cout << pagesNumberingWithInk(76, 250) << endl;
}
