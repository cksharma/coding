#include <bits/stdc++.h>
using namespace std;

class C2IncreasingSubsequenceHardVersion {
public:
    void solve(istream& cin, ostream& cout) {
        ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
        cout.setf(ios::fixed); cout.precision(20);

        int n; cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; ++i) cin >> arr[i];

        string ans;
        int left = 0, right = n - 1; int cnt = 0; int max = INT_MIN;
        while (left <= right) {
            if (arr[left] == arr[right] and arr[left] > max) {
                int leftCnt = 1, rightCnt = 1;
                int l1 = left + 1, r1 = right - 1;
                while (l1 < right and arr[l1] > arr[l1 - 1]) {
                    leftCnt++;
                    l1++;
                }
                while (r1 > left and arr[r1] > arr[r1 + 1]) {
                    rightCnt++;
                    r1--;
                }

                if (leftCnt > rightCnt) {
                    cnt += leftCnt;
                    for (int i = 0; i < leftCnt; ++i) ans += "L";
                } else {
                    cnt += rightCnt;
                    for (int i = 0; i < rightCnt; ++i) ans += "R";
                }
                break;
            }
            else if (arr[left] > max and arr[right] > max) {
                max = min(arr[left], arr[right]);
                if (arr[left] < arr[right]) {
                    ans += "L";
                    left++;
                } else {
                    ans += "R";
                    right--;
                }
            } else if (arr[left] > max) {
                max = arr[left];
                ans += "L";
                left++;
            } else if (arr[right] > max) {
                max = arr[right];
                ans += "R";
                right--;
            } else {
                break;
            }
            cnt++;
        }
        cout << cnt << "\n" << ans << "\n";

    }
};
