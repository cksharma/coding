#include <bits/stdc++.h>
using namespace std;

int main()
{
    ofstream fileStream("a.text");
    int n; cin >> n;
    ostream& os = n % 2 ? cout : fileStream;
    os << "This is the best\n";
    return 0;
}
