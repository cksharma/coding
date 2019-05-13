#include <bits/stdc++.h>
using namespace std;

template <typename K, typename V>
struct LRUCache {
    map<K, typename list<pair<K, V>>::iterator> cache;
    list<pair<K, V>> items;

    vector< pair<K, V> > v;
    set< pair<K, V> > st;
    map<K, vector<K>> ad;

    void addItem(K key, V value) {
        auto p = make_pair( key, value );
        if(cache.find(key) != cache.end()) {
            auto it = cache[key];
            items.erase(it);
            cache.erase(key);
        } else {
            if( items.size() >= N )
                deleteLRU();
        }
        items.push_front(p);
        cache[key] = items.begin();
    }

    V query(K key) {
        if( cache.find(key) != cache.end() ) {
            auto it = cache[key];
            auto p = *it;
            items.erase(it);
            cache.erase(key);
            items.push_front(p);
            cache[key] = items.begin();
            return p.second;
        } else {
            throw runtime_error("Invalid Query");
        }
    }

    void printItems() {
        for(auto p : items) {
            cout << "( " << p.first << ", " << p.second << "), ";
        }
        cout << endl;
    }

    LRUCache(int n) : N(n) {}

private:
    void deleteLRU() {
        auto item = items.back();
        int key = item.first;
        int val = item.second;
        cache.erase(key);
        items.pop_back();
    }

    int N;
};

int main()
{
    LRUCache<int, int> lru(5);
    lru.addItem(1, 10);
    lru.addItem(4, 40);
    lru.addItem(2, 20);
    lru.addItem(3, 30);
    lru.addItem(5, 50);
    lru.addItem(6, 60);
    lru.printItems();
    cout << "Query for 5 " << lru.query(5) << endl;
    lru.printItems();
}
