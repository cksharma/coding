#include <bits/stdc++.h>
using namespace std;

struct Node {
    string key;
    int value;
    Node(string k, int v) : key(k), value(v) {}
};

struct LRUCache {
    int cap;
    LRUCache(int c) : cap(c) {}
    list< Node* > data;
    map< string, list<Node*>::iterator > cache;

    void add(const string& key, int value) {
        auto mit = cache.find( key );
        if( mit != cache.end()) {
            auto lit = mit->second;
            data.erase( lit );
            cache.erase( mit );
        } else if( data.size() == cap) {
            cache.erase( data.back()->key);
            data.pop_back();
        }
        Node* n = new Node(key, value);
        data.push_front( n );
        cache.insert( make_pair( key, data.begin()) );
    }

    const Node* query(string key) {
        auto mit = cache.find(key);
        if( mit != cache.end()) {
            Node* node = *(mit->second);
            data.erase(mit->second);
            data.push_front(node);
            cache[key] = data.begin();
            return node;
        }
        throw runtime_error("This is not present in cache");
    }

    void print(){
        auto lit = data.begin();
        while( lit != data.end()) {
            cout << (*lit)->key << "=" << (*lit)->value << "\n";
            ++lit;
        }
    }
};

int main()
{
    LRUCache cache(5);
    string s1 = "Chandra1"; int v1 = 1;
    string s2 = "Chandra2"; int v2 = 2;
    string s3 = "Chandra3"; int v3 = 3;
    string s4 = "Chandra4"; int v4 = 4;
    string s5 = "Chandra5"; int v5 = 5;
    string s6 = "Chandra6"; int v6 = 6;

    cache.add( s1, v1 );
    cache.add( s2, v2 );
    cache.add( s1, v1 );
    cache.add( s3, v3 );

    cache.print();
    cout << "=======" << endl << endl;

    cache.add( s5, v5 );
    cache.add( s6, v6 );
    cache.query(s2);
    cache.add( s4, v4 );
    cache.print();

}