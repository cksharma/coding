#include <bits/stdc++.h>
#define long long long
using namespace std;

std::string cipher26(std::string message) {
    int n = message.size(); string ans(n, ' ');
    int sum = message[0] - 'a';
    ans[0] = message[0];
    for (int i = 1; i < n; ++i) {
        int him = (message[i] - 'a' - sum + 26) % 26;
        ans[i] = (char)(him + 'a');
        sum = sum + (ans[i] - 'a');
        sum %= 26;
    }
    return ans;
}

int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);
    cout << cipher26("taiaiaertkixquxjnfxxdh") << endl;
}
