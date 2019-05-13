#include <bits/stdc++.h>

struct Key {
    std::string first;
    std::string second;
    int third;

    bool operator==(const Key& key) const {
        return key.first == this->first && key.second == this->second
               && key.third == this->third;
    }
    Key() {}
    Key(const std::string& f, const std::string& s, int t) :
    first(f), second(s), third(t){}
};

std::ostream& operator<<(std::ostream& os, const Key& key) {
    os << "[" << key.first << ", " << key.second << ", " << key.third << "]";
    return os;
}

struct KeyHasher
{
  std::size_t operator()(const Key& k) const
  {
    using std::size_t;
    using std::hash;
    using std::string;

    return ((hash<string>()(k.first)
             ^ (hash<string>()(k.second) << 1)) >> 1)
             ^ (hash<int>()(k.third) << 1);
  }
};

int main()
{
    Key k1 = {"John", "Doe", 12 };
    Key k2 = {"Mary", "Sue", 21 };
    Key k3 = {"Chandra", "Sharma", 30 };

    std::unordered_map<Key,std::string,KeyHasher> m6 = {
        { k1, "example"},
        { k2, "another"}
    };

    auto KeyHash = []( const Key& k ) {
        return std::hash<std::string>()( k.first );
    };
    std::unordered_map< Key, std::string, decltype(KeyHash) > mp(10, KeyHash);
    mp = { {k1, "One" }, {k2, "Two" }, {k3, "Three" }, {k3, "Three" } };
    std::cout << "Size " << mp.size() << std::endl;

    std::for_each(mp.begin(), mp.end(), []( auto p ) { std::cout << p.first << ", " << p.second << std::endl; } );

    auto KeyHashLambda = []( const Key& key) {
        return std::hash<std::string>()(key.first) << 1 +
               std::hash<std::string>()(key.second) << 2 +
               std::hash<int>()(key.third) << 3;
    };
    auto KeyEquality = [](const Key& k1, const Key& k2) {
        return k1.first == k2.first && k1.second == k2.second && k1.third == k2.third;
    };

    std::unordered_map<Key, bool, decltype(KeyHashLambda), decltype(KeyEquality)> ckMap(10, KeyHashLambda, KeyEquality);
    ckMap = { {k1, true }, {k1, true } };
    std::cout << ckMap.size() << std::endl;

    auto KeyComparatorLambda = [](const Key& k1, const Key& k2) {
        if( k1.first != k2.first) return k1.first < k2.first;
        if(k1.second != k2.second) return k1.second < k2.second;
        return k1.third < k2.third;
    };

    std::map< Key, bool, decltype(KeyComparatorLambda) > treeMap( KeyComparatorLambda);
    treeMap = { {k1, true}};
    std::cout << "Size tMap " << treeMap.size() << std::endl;
    return 0;
}
