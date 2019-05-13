#include <bits/stdc++.h>
using namespace std;

class BlockTowers {

public:
    int findHeightBinarySearch(int n, int m) {
        int left = 1, right = max(n, m) * 6;
        while (left + 1 < right) {
            int middle = (left + right) / 2;
            int onlyTwo = middle / 2 - middle / 6;
            int onlyThree = (middle + 3) / 6;
            int both = middle / 6;
            if (onlyTwo + both >= n && onlyThree + both >= m && onlyTwo + onlyThree + both >= n + m) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }
};

int main() {
    BlockTowers bt;
    int n, m;
    std::ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> n >> m;
    cout << bt.findHeightBinarySearch(n, m) << endl;
}