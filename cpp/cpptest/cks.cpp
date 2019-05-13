#include <bits/stdc++.h>
using namespace std;
struct Person {
    std::string name;
    int age;
};

struct PersonHash {
    std::size_t operator()(const Person& p) const {
        return std::hash<int>()(p.age) + std::hash<std::string>()(p.name);      
    }
};

struct PersonEquals {
    bool operator()(const Person& lhs, const Person& rhs) const {
        return lhs.name == rhs.name && lhs.age == rhs.age;      
    }
};

void personTest()
{
    Person p { "chandra", 10 };
    std::unordered_map<Person, bool, PersonHash, PersonEquals> hMap { { Person{"ck", 10}, true } };
    std::cout << hMap.size() << std::endl;
}

int main()
{
    string s = "abacbefa";
    map<char, int> indexMap;
    int start = 0, end = 1; indexMap[s[0]] = 0; int len = INT_MIN; int a = 0, b = 0;
    for (int i = 1; i < s.size(); ++i) {
        auto it = indexMap.find(s[i]);
        if (it != indexMap.end() && it->second >= start)
        {
            if (end - start > len) {
                len = end - start;
                a = start;
                b = end;
            }
            start = it->second + 1;        
            indexMap.erase(s[i]);
        }
        indexMap[s[i]] = i;
        ++end;
    }
    cout << "CKS haha" << len << endl;
    cout << ( (len == INT_MIN) ? s : s.substr(a, b - a) ) << endl;
}