#include <bits/stdc++.h>
using namespace std;

std::vector<std::string> sortByLength(std::vector<std::string> inputArray) {
    map<int, vector<string>> mp;
    for (const auto& item : inputArray) {
        mp[item.size()].push_back(item);
    }
    vector<string> result;
    for (const auto& [k, v] : mp) {
        for (const auto& item : v) {
            result.push_back(item);
        }
    }
    return result;
}


int main()
{

}