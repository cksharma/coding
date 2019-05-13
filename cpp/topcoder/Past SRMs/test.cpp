#include <bits/stdc++.h>
using namespace std;

int partition(vector<int>& arr, int s, int e)
{
    int s1 = s;
    int pvt = arr[s];

    while (s < e)
    {
        for( ; s < arr.size() && arr[s] <= pvt; ) s++;
        for( ; e >= 0 && arr[e] > pvt; ) e--;

        if (s < e) swap(arr[s], arr[e]);
    }
    swap(arr[e], arr[s1]);
    return max(e, 0);
}

int getKthSmallest(vector<int>& arr, int s, int e, int k)
{
    int pivot = partition(arr, s, e);
    if (s >= e || k < 0) return arr[s];
    if (pivot == k + s) return arr[pivot];

    if (pivot > k + s) {
        return getKthSmallest(arr, s, pivot - 1, k);
    } else if ( pivot < k + s) {
        return getKthSmallest(arr, pivot + 1, e, k - (pivot - s + 1));
    }
}

int getKthSmallest(vector<int>& arr, int k)
{
    if (k > arr.size()) return INT_MAX;
    return getKthSmallest(arr, 0, arr.size() - 1, k - 1);
}

ostream& operator<<(ostream& os, const vector<int>& v) {
    for (int item : v) os << item << ", ";
    return os;
}

int main()
{
    for (int i = 1; i <= 11; ++i)
    {
        vector<int> v = {5, 3, 4, 2, 1, 10, 11, 14, 16, 17};
        random_shuffle(v.begin(), v.end());
        //cout << "Original vector " << v << endl;
        //cout << "Pivot:" << v[0] << endl;
        //int idx = partition(v, 0, v.size() - 1);
        //cout << " idx = <" << idx << "> After partition " << v << endl << endl;
        cout << i << " th smallest: " << getKthSmallest(v, i) << endl;
    }
}