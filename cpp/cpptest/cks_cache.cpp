#include <bits/stdc++.h>
using namespace std;

struct Cache {
    list<pair<int, int>> numbers;
    unordered_map<int, list<pair<int, int>>::iterator> mp;
    int size = 5;
    
    void add(int key, int value)
    {
        remove(key);
        numbers.push_front(make_pair(key, value));
        mp[key] = numbers.begin();
        if (numbers.size() > size) {
            auto p = numbers.back();
            numbers.pop_back();
            mp.erase(p.first);
        }
    }
    
    void remove(int key)
    {
        auto it = mp.find(key);
        if ( it != mp.end()) {
           numbers.erase(it->second);
           mp.erase(key);
        }
    }
    void print()
    {
        cout << "[";
        for (auto item : numbers) cout << "(" << item.first << ", " << item.second << ")";
        cout << "]" << endl; 
    }
    int query(int key)
    {
        int ans = -1;
        if (mp.find(key) != mp.end()) {
            ans = (*mp.find(key)->second).second;
            add(key, ans);
            
        }
        return ans;
    }
};

int main()
{
    Cache cache;
    for (int i = 1; i < 10; ++i) {
        cache.add(i, i);
        if (i == 6) cache.print();
        
    }
    cache.print(); 
    cout << "Query" << cache.query(6) << endl;
    cache.print();
    
    cout << "Query" <<cache.query(100) << endl;
    cache.print();
}