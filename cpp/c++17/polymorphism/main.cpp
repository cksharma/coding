#include <bits/stdc++.h>

class Base {
  private:
    void privateFunc() { std::cout << "Private function" << std::endl;}
  protected:
    void protectedFunc() {std::cout << "protected function" << std::endl;}
  public:
    void publicFunc() {std::cout << "public function" << std::endl;}
};

class DerivedPrivate : Base {
  private:
    void test1() {
        //privateFunc();
        protectedFunc();
        publicFunc();
    }
  public:
    void test2() {
        test1();
    }
};

int main()
{
    DerivedPrivate dp;
    dp.test2();
    return 0;
}