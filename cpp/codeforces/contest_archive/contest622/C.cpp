#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
    ll n;
    cin >> n;
    vector<ll> v(n);
    for (int i = 0; i < n; ++i) cin >> v[i];
    
    vector<ll> result; ll sum = 0; 
    for (int mid = 0; mid < v.size(); ++mid) {
        ll temp = 0LL; vector<ll> vtemp(n);
        temp += v[mid]; vtemp[mid] = v[mid];
        
        for (int left = mid - 1; left >= 0; --left) {
            ll h = min(vtemp[left + 1], v[left]);
            temp += h;
            vtemp[left] = h;
        }
        
        for (int right = mid + 1; right < v.size(); ++right) {
            ll h = min(vtemp[right - 1], v[right]);
            temp += h;
            vtemp[right] = h;
        }
        
        if (temp > sum) {
            result = vtemp;
            sum = temp;
        }
    }
    for (ll item : result) {
        cout << item << " ";
    }
}
