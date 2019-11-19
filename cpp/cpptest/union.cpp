#include <bits/stdc++.h>
using namespace std;

union Type {
    string ce;
    vector<int> vi;
    bool isT2T;
    ~Type() {}
};



ostream& operator<<(ostream& os, const Type& type) {
    cout << "Ce =" << type.ce << endl;
    cout << "vi_sz=" << type.vi.size() << endl;
    cout << "isT2T=" << type.isT2T << endl;
}

enum Entity {
    UNKNOWN,
    CROSS,
    BRANCH
};

int main()
{
    Type t {"Chandra" };
    cout << t << endl;

    //t.ce.~basic_string();
    //cout << t << endl;

    /*new (&t.vi) vector<int>( {1, 2, 3, 4} );
    cout << t << endl;

    Entity et = CROSS;
    cout << et << endl;
    et = UNKNOWN;
    cout << et << endl;
    et = BRANCH;
    cout << et << endl;*/

    t.vi = {1, 2, 3, 4, 65};
    cout << t << endl;
}