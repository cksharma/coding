#include <bits/stdc++.h>
using namespace std;

struct Person {
    std::string name;
    int age;

    /*bool operator==(const Person& rhs) const {
        return name == rhs.name && age == rhs.age;
    }*/
};

struct PersonHash {
    std::size_t operator()(const Person& p) const {
        return std::hash<int>()(p.age) + std::hash<std::string>()(p.name);
    }
};

struct PersonEquality {
    bool operator()(const Person& p1, const Person& p2) const {
        return p1.name == p2.name && p1.age == p2.age;
    }
};

struct PersonComparator {
    bool operator()(const Person& p1, const Person& p2) const {
        if(p1.name != p2.name) return p1.name < p2.name;
        return p1.age < p2.age;
    }
};

template <typename K, typename V, typename H, typename E>
using HashMap = std::unordered_map<K, V, H, E >;

void testPerson()
{
    Person p1 { "chandra", 10 };
    std::unordered_map<Person, bool, PersonHash, PersonEquality> mp;
    mp.insert( std::make_pair( p1, true ) );
    std::cout << mp.size() << std::endl;

    std::map<Person, bool, PersonComparator> m1 { { Person{"chnadra", 10}, true }};
    std::cout << m1.size() << std::endl;

    auto LambdaPersonHash = [](const Person& p) {
        return std::hash<int>()(p.age) + std::hash<std::string>()(p.name);
    };
    auto LambdaPersonEquals = [](const Person& lhs, const Person& rhs) {
        return lhs.name == rhs.name && lhs.age == rhs.age;
    };
    auto LambdaPersonComparator = [](const Person& lhs, const Person& rhs) {
        if(lhs.name != rhs.name) return lhs.name < rhs.name;
        return lhs.age < rhs.age;
    };

    HashMap< Person, bool, PersonHash, PersonEquality > hashMap;
    hashMap.insert( std::make_pair( p1, false) );
    std::cout << hashMap.size() << std::endl;

    HashMap< Person, bool, decltype( LambdaPersonHash ), decltype( LambdaPersonEquals ) > hMap(10, LambdaPersonHash, LambdaPersonEquals );
    std::cout << hMap.size() << std::endl;
}

void atoi_stoi()
{
    cout << atoi("123") << endl;
    cout << stoi("123") << endl;
}

int main()
{
    //testPerson();
    auto num {10};
    auto k = {10};
    cout << num << " , " << endl;
    for (auto item : k) cout << item << ", " ;
    
    atoi_stoi();
    
    return 0;
}