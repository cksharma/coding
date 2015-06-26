// shared_ptr::owner_before
#include <iostream>
#include <memory>

int main () {
    int * p = new int (10);

    std::shared_ptr<int> a (new int (20));
    std::shared_ptr<int> b (a,p);  // alias constructor

    std::cout << "comparing a and b...\n" << std::boolalpha;
    std::cout << "value-based: " << ( !(a<b) && !(b<a) ) << '\n';
    std::cout << "owner-based: " << ( !a.owner_before(b) && !b.owner_before(a) ) << '\n';
    std::cout << "A's use count " << a.use_count() << std::endl;
    std::cout << "B's use count " << b.use_count() << std::endl; 
  
    using namespace std;
    shared_ptr<int> p1 = make_shared<int> (3);
    shared_ptr<int> p2 = p1;
    cout << " Owner before " << p2.owner_before(p1) << endl;    
    
        
    delete p;
    return 0;
}
