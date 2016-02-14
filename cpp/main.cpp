#include <bits/stdc++.h>

using namespace std;

class Human {
private:
    int* age;
    string* name;

public:
    Human(int age1, string name1) {
        age = new int;
        name = new string;
        *age = age1;
        *name = name1;
    }
    void print( ) {
        cout << "print" << endl;
        cout << *age << endl;
        cout << *name << endl;
    }
    ~Human() {
        delete age;
        delete name;
    }
};

int main()
{
    cout << "Came her" << endl;
    Human* human = new Human(1, "cks");
    human->print();
    delete human;
    return 0;
}