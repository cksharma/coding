#include <bits/stdc++.h>
using namespace std;

struct Parent {
    string name;
    int age;
    string sex;

    virtual string getSex() = 0;
    int getAge() { return age; }
    string getName() { return this->name;}
    virtual string toString() = 0;
};

struct Mother : public Parent {
    string getSex() override { return "F"; }

    Mother(string name, int age) {
        this->name = name;
        this->age = age;
    }
    virtual string toString() override { return name + to_string(age) + getSex(); }
};

struct Father : public Parent {
    string getSex() override { return "M"; }

    Father(string name, int age) {
        this->name = name;
        this->age = age;
    }
    virtual string toString() override { return name + to_string(age) + getSex(); }
};

int get4k(char* ch) {
    char* mydata = "Chandra";
    int len = 7;
    memcpy(ch, mydata, len);
    return len;
}

int myAPI(char* user) {
    char* ch = new char[4096];
    int len = get4k(ch);
    memcpy(user, ch, len);
    return len;
}


int main()
{
    ios::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    Parent* mother = new Mother("Mother", 40); cout << mother->toString() << endl;
    Parent* father = new Father("Father", 40); cout << father->toString() << endl;

    char* ck = new char[100];
    int myLen = myAPI(ck);
    for (int i = 0; i < myLen; ++i) { cout << ck[i] << "";}
    cout << endl;
}
