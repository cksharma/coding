#include <bits/stdc++.h>
using namespace std;

class Solution {

    void recurse*

public:
    vector<string> findItinerary(vector<pair<string, string>> tickets) {

    }
};

int main() {
    vector<pair<string, string>> tickets = { {"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},
                                       {"ATL","JFK"},{"ATL","SFO"}};
    vector<string> v = Solution().findItinerary(tickets);
    for (auto& item : tickets) cout << item << ", ";
}