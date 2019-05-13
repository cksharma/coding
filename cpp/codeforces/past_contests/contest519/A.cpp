#include <bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;
	vector<int> v(n);
	for(int i = 0; i < n; i++) cin >> v[i];
	
	int ans = *max_element( v.begin(), v.end() );
	int e = accumulate(v.begin(),  v.end(), 0);
	while(true) {
		int a = n * ans - e;
		if( a > e ) {
			break;
		} 
		ans++;
	}
	cout << ans << endl;
	return 0;
}