#include <memory>
#include <string>
#include <iostream>
using namespace std;

class Dog {
    string name_;
    public:
        Dog(string name) {
            cout << "Dog is created: " << name << endl;
            name_ = name;
        }

        Dog() {
            cout << "Nameless dog created. " << endl;
            name_ = "nameless";
        }
        ~Dog() {
            cout << "dog is destroyed: " << name_ << endl;
        }
        void bark() {
            cout << "Dog " << name_ << " rules!" << endl;
        }
};

void foo() {
    shared_ptr<Dog> p1 = make_shared<Dog>("Gunner");
    shared_ptr<Dog> p2 = shared_ptr<Dog>(new Dog("Tank"),
                        [] (Dog *p) { cout << "Custom deleting."; delete p;});
    cout << "jjj\n";
}

int main() {
    foo();
}
