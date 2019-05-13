#include <bits/stdc++.h>
using namespace std;

template<typename T> 
void func(T param) {
    cout << "By value " << param << endl;
}

int main() {
    string str = "Chandra";
    string* sp = &str;
    
    cout << sp << endl;
    
    func( sp );
    return 0;
}