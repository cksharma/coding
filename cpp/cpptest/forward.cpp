#include <bits/stdc++.h>
using namespace std;

decltype(auto) getValue()
{
    int x = 10;
    return x;
}

decltype(auto) getValue1()
{
    static int x = 10;
    return (x);
}

template <typename Container, typename Index>
decltype(auto) getTheItem(Container&& c, Index i)
{
    return forward<Container>(c)[i];
}

struct Person {
    string name;
    int age;
    char gender;

    bool operator<(const Person& p) const {
        if (name != p.name) return name < p.name;
        if (age != p.age) return age < p.age;
        return gender < p.gender;
    }

    bool operator==(const Person& p) const {
        return not(*this < p) and not(p < *this);
    }

};

struct PersonComparator {
    bool operator()(const Person& p1, const Person& p2) const {
        if (p1.name != p2.name) return p1.name < p2.name;
        if (p1.age != p2.age) return p1.age < p2.age;
        return p1.gender < p2.gender;
    }
};

struct PersonHash {
    size_t operator()(const Person& p) const {
        return hash<string>()(p.name) + hash<int>()(p.age) + hash<char>()(p.gender);
    }
};

struct PersonEquals {
    bool operator()(const Person& lhs, const Person& rhs) const {
        return lhs.name == rhs.name and lhs.age == rhs.age and lhs.gender == rhs.gender;
    }
};

struct Widget {

};

void testCKS()
{
    auto features = [](const Widget& w) {
        vector<bool> vec(6);
        for (int i = 0; i < 6; ++i) vec[i] = (i % 2 == 0);
        return vec;
    };
    Widget w;
    bool f = features(w)[5]; cout << "CKS " << f << endl;
    auto f1 = features(w)[5]; cout << "CKS " << f1 << endl;
}

void testBookReference()
{
    vector<bool> v(10, false);
    for (int i = 0; i < 10; ++i) v[i] = i % 2 == 0;
    bool k = v[0];
    cout << "CKS kya baat kar raha hai " << k << endl;
}

bool booleanFunction()
{
    return false;
}

void testBooleanFunctor()
{
    bool k = booleanFunction;
    cout << "CKS ka boolean functor " << k << endl;
}

void old_stuffs()
{
    cout << getValue() << endl;
    cout << getValue1() << endl;
    vector<int> v = {1, 2, 3, 4};
    cout << getTheItem(v, 3) << endl;

    Person p1{"chandra", 10, 'M'};
    Person p2{"neepa", 20, 'F'};
    set<Person> s1 = {p1, p2}; cout << s1.size() << endl;
    set<Person, PersonComparator> s2 = {p1, p2}; cout << s2.size() << endl;
    set<Person> s3 = {p1, p2, p1, p2}; cout << s3.size() << endl;
    set<Person, PersonComparator> s4 = {p1, p2, p1, p2}; cout << s4.size() << endl;
    auto PersonLambdaComparator = [](const auto& lhs, const auto& rhs) {
        if (lhs.name != rhs.name) return lhs.name < rhs.name;
        if (lhs.age != rhs.age) return lhs.age < rhs.age;
        return lhs.gender < rhs.gender;
    };
    set<Person, decltype(PersonLambdaComparator)> st(PersonLambdaComparator);
    st.insert({p1, p2, p1, p2});
    cout << st.size() << endl;

    auto PersonLambdaHash = [](const Person& p) {
        return hash<string>()(p.name) + hash<int>()(p.age) + hash<char>()(p.gender);
    };
    auto PersonLambdaEquality = [](const Person& lhs, const Person& rhs) {
        return lhs.name == rhs.name and lhs.age == rhs.age and lhs.gender == rhs.gender;
    };
    unordered_map<Person, bool, PersonHash, PersonEquals> mp;
    mp.insert( make_pair(p1, true) );     mp.insert( make_pair(p2, true) );
    cout << "CKS is here " << mp.size() << endl;

    unordered_map<Person, bool, decltype(PersonLambdaHash), decltype(PersonLambdaEquality)> mp1(10, PersonLambdaHash, PersonLambdaEquality);
    mp1.insert( make_pair(p1, true) );     mp1.insert( make_pair(p2, true) );
    cout << "CKS is here " << mp1.size() << endl;

    testCKS();
    testBookReference();
    testBooleanFunctor();
}

void solve(vector<vector<int>>& v, const vector<int>& super, vector<int>& sub, int idx) {
    if (idx >= super.size()) return;
    sub.emplace_back(super[idx]);
    v.push_back(sub);

    solve(v, super, sub, idx + 1);
    sub.pop_back();
    solve(v, super, sub, idx + 1);
}

ostream& operator<<(ostream& os, const vector<int>& v) {
    for (int item : v) os << item << ", ";
    return os;
}

void soltie()
{
    vector<vector<int>> v;
    vector<int> super {1, 2, 3, 4}, sub;
    solve(v, super, sub, 0);
    for (auto& vv : v) cout << vv << endl;

    map<int, int> mp;
}

int main()
{
    //old_stuffs();
    soltie();
    return 0;
}