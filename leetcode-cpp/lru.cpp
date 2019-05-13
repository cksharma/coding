#include <bits/stdc++.h>
using namespace std;

class LRUCache {
  private:
  	list<pair<int, int>> linkedList;
	unordered_map<int, list<pair<int, int>>::iterator> cache;
	int capacity;
   
  public:
    LRUCache(int capacity_) {
    	this->capacity = capacity_;
    }
    
    int get(int key) {
    	auto cacheIt = cache.find(key);
    	if(cacheIt == cache.end()) return -1;
    	int value = cacheIt->second->second;
    	put(key, value);
    	return value;
    }
    
    int size() { return linkedList.size(); }
    
    void put(int key, int value) {
    	if( capacity <= 0 ) return;
    	pair<int, int> p{ key, value };
		auto cacheIt = cache.find( key );
		if( cacheIt != cache.end() ) {
			linkedList.erase( cacheIt->second );
			cache.erase( key );
		}
		if(linkedList.size() >= capacity) {
			int key = linkedList.back().first;
			linkedList.pop_back();
			cache.erase( key );			
		}
		linkedList.push_front( p );
		cache.insert( make_pair(key, linkedList.begin()) );
    }
};

int main() {
	LRUCache lru(10);
	lru.put(10,13);
	lru.put(3,17);
	lru.put(6,11);
	lru.put(10,5);
	lru.put(9,10);
	cout << lru.get(13) << endl;
	lru.put(2,19);
	cout << lru.get(2) << endl;
	cout << lru.get(3) << endl;
	lru.put(5,25);
	cout << lru.get(8) << endl;
	lru.put(9,22);
	lru.put(5,5);
	lru.put(1,30);
	cout << lru.get(11) << endl;
	lru.put(9,12);
	cout << lru.get(7) << endl;
	cout << lru.get(5) << endl;
	cout << lru.get(8) << endl;
	cout << lru.get(9) << endl;
	lru.put(4,30);
	lru.put(9,3);
	//cout << lru.get(9) << endl;
	//cout << lru.get(10) << endl;
	//cout << lru.get(10) << endl;
	//lru.put(6,14);
	//lru.put(3,1);
	//cout << lru.get(3) << endl;
	//,[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]
}
