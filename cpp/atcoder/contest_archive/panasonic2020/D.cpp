#include <bits/stdc++.h>
using namespace std;
using ll = long long;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    cout.setf(ios::fixed);
    cout.precision(10);
    
    int N; cin >> N;
    queue<string> Q;
    Q.push("a");
    set<string> ST;
    ST.insert("a");
    
    auto ok = [](const string& str) {
        char mx = 'a';
        for(char c:str) {
            if (c > mx+1) return false;
            mx = max(mx, c);
        }
        return true;
    };
    
    while (true) {
        string s = Q.front();
        if (s.size() > N) break;
        Q.pop();
        char left = max('a', (char)(s.back() - 1) );
        char right = (char)(s.back() + 1);
        
        //cout << "left<" << left << ">" << ", right<" << right << ">\n"; 
        
        //cout << "[";
        for (char c = 'a'; c <= 'j'; ++c) {
            string temp = s + string(1, c);
            //cout << "" << temp << ", ";
            Q.push(temp);
            ST.insert(temp);
        }
        //cout << "], \n";
    }
    
    vector<string> v;
    for (auto& item : ST) {
        if (item.size() == N) {
            v.push_back(item);
        }
    }

    auto isNormal = [](const string& s1, const string& s2) {
        int n = s1.size();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (s1[i] == s1[j] && s2[i] == s2[j]) continue;
                if (s1[i] != s1[j] && s2[i] != s2[j]) continue;
                return false;
            }
        }
        return true;
    };
    
    sort(v.begin(), v.end());
    for (int i = 0; i < v.size(); ++i) {
        bool good = true;
        for (int j = 0; j < i; ++j) {
            if (isNormal(v[j], v[i])) {
                good = false;
                break;
            }
        }
        if (good) cout << v[i] << "\n";
    }
}
