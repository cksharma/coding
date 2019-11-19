#include <iostream>
#include <string>
#include <vector>
using namespace std;

struct Feature {
    float x;
    float y;
    float value;
};

class Person {
    string name;
  public:
    string getName() const { return name; }

};

class BaseClass {
public:
    int GetDetections(const std::string& filename)  const {
        // Normally, I'd read in features from a file, but for this online
        // example, I'll just construct an feature set manually.
        std::vector<Feature> features;
        return GetDetections(features);
    };
    // Pure virtual function.
    virtual int GetDetections(const std::vector<Feature>& features) const  = 0;
};

class SubClass : public BaseClass {
public:
    // Giving the pure virtual function an implementation in this class.
    int GetDetections(const std::vector<Feature>& features)  const  {
        return 7;
    }
};

int main() {
    SubClass s;
    std::cout << s.BaseClass::GetDetections("testfile.txt");
    std::cout << s.BaseClass::GetDetections("testfile.txt");
}