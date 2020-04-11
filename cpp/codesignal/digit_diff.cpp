#include <bits/stdc++.h>
using namespace std;

int getMinMaxDiff(int num);

struct Digit {
    int num;
    int index; 
    
    bool operator<(const Digit& rhs) const
    {
        int diff1 = getMinMaxDiff(this->num);
        int diff2 = getMinMaxDiff(rhs.num);
        if (diff1 != diff2) return diff1 < diff2;
        return this->index > rhs.index;
    }    
};

int getMinMaxDiff(int num) 
{
    int mini = INT32_MAX;
    int maxi = INT32_MIN;
    while (num > 0)
    {
        int d = num % 10;
        mini = min(mini, d);
        maxi = max(maxi, d);
        num /= 10;
    }
    return maxi - mini;
}

std::vector<int> digitDifferenceSort(std::vector<int> a) 
{
    vector<Digit> digits(a.size());
    for (int i = 0; i < a.size(); ++i) {
        digits[i] = {a[i], i};
    }
    sort(digits.begin(), digits.end());
    vector<int> ans(a.size());
    for (int i = 0; i < a.size(); ++i) {
        ans[i] = digits[i].num;
    }
    return ans;
}

ostream& operator<<(ostream& os, const vector<int>& v) {
    for (auto item : v) os << item << ", ";
    return os;
}

int main()
{
    vector<int> v = {152, 23, 7, 887, 243};
    cout << digitDifferenceSort(v) << endl;       
}
