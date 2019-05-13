#include <stdexcept>
#include <iostream>
#include <string>

struct Person {
    std::string name;
    int age;

    ~Person() {
        std::cout << "Cleaning the garbages Cygwin" << std::endl;
    }

};

int main()
{
    try {
        Person p{"Chandra", 10};
        throw std::runtime_error("Chandra");
    } catch(std::exception& ex) {
        std::cout << ex.what() << std::endl;
    }
}