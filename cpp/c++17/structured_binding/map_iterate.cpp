#include <bits/stdc++.h>
using namespace std;

int main()
{
    map<string, int> mapUsersAge { {"Chandra", 10}, {"hari", 20}};
    
    auto [iter, wasAdded] = mapUsersAge.insert_or_assign("Chandra", 20);
    cout << iter->first << " reassigned " << boolalpha << wasAdded << endl;
    
    for (const auto& [key, value] : mapUsersAge) {
        cout << key << ", " << value << "\n";
    }   
    
}
