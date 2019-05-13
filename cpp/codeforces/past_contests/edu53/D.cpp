#include <bits/stdc++.h>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int n; cin >> n;
	long long T; cin >> T;
	vector<long long> A(n);
    for(int i = 0; i < n; i++) {
        cin >> A[i];
    }

	long long ans = 0LL;
	vector<long long> cumulative(n); cumulative[0] = A[0];
	for(int i =1; i < n; ++i) {
		cumulative[i] = cumulative[i - 1] + A[i];
	}
    long long mini = *min_element( A.begin(), A.end());
    long long factor = T / cumulative[ n - 1];
    ans += n * factor;
    T -= cumulative[n - 1] * factor;

    while ( T >= mini ) {
        long long sum = 0, Temp = T, cnt = 0;
        for(int i = 0; i < n; ++i) {
            if( Temp >= A[i] ) {
                Temp -= A[i];
                sum += A[i];
                cnt++;
            }
        }
        ans += cnt * ( T / sum );
        T %= sum;
    }
	cout << ans << endl;
}
