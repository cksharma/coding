#include <bits/stdc++.h>

using namespace std;
const int n = 5000000 + 1;

int cnt[n];
int arr[n];

void preProcess() {
    for (int i = 1; i < n; i++) {
        arr[i] = i;
    }
    fill(cnt, cnt + n, 0);

    for (int i = 2; i * i < n; i++) {
        if (cnt[i] == 0) {
            for (int j = i; j < n; j += i) {
                while (arr[j] > 1 && arr[j] % i == 0) {
                    arr[j] /= i;
                    cnt[j]++;
                }
            }
        }
    }
    int sum = 0;
    for (int i = 2; i < n; i++) {
        if (cnt[i] == 0) cnt[i] = 1;
        else if (arr[i] > 1) sum++;
        sum += cnt[i];
        cnt[i] = sum;
    }
}

int main() {
    std::ios::sync_with_stdio(false);
    preProcess();
    int t, a, b;
    scanf("%d", &t);
    while (t-- > 0) {
        scanf("%d %d", &a, &b);
        printf("%d\n", (cnt[a] - cnt[b]));
    }
}