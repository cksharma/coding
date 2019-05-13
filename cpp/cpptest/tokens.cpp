#include <bits/stdc++.h>
using namespace std;

bool isMAC48Address(std::string inputString) {
    stringstream ss(inputString);
    string token; vector<string> tokens;
    while (getline(ss, token, '-')) {
        cout << "Token" << token << ", ";
        if (token.size() != 2) return false;
        tokens.push_back(token);
        
    }
    if (tokens.size() != 6) return false;
    for (int i = 0; i < tokens.size(); ++i) {
        for (char f : tokens[i]) {
            if ((f >= 'A' && f <= 'Z') or (f >= '0' && f <= '9') ) continue;
            return false;
        }
    }
    return true;
}

void testTokens(string str, char delimiter)
{
   istringstream iss(str);
   while (iss.good())
   {
        string token;
        getline(iss, token, delimiter);
        cout << token << endl;
   }
}

int main()
{
//    cout << "OKAY = " << isMAC48Address("00-1B-63-84-45-E6") << endl;
    testTokens("Chandr a@gmail.com", '@');
}