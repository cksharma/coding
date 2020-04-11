#include <bits/stdc++.h>

using namespace std;

class DSuperM {
public:

    map<pair<int, int>, int> costmap;
    map<int, set<int> > neighbourmap;
    set<int> attkcities;
    int global;

    int dfs(int start, int city, set<int> &attkpath, set<int> &allpath) {

        if (allpath.find(city) != allpath.end()) return 0;

        set<int> &neighbours = neighbourmap[city];

        allpath.insert(city);
        int cost = 0;
        for (int neighbour : neighbours) {
            if (allpath.find(neighbour) == allpath.end()) {
                int myval = dfs(start, neighbour, attkpath, allpath);
                cost += myval;
            }
        }

        if (attkcities.find(city) != attkcities.end() || cost != 0) {
            if (city != start)
                cost = cost + 1;
        }
        return cost;
    }

    void solve(istream &cin, ostream &cout) {
        ios_base::sync_with_stdio(false);
        cin.tie(nullptr);
        cout.tie(nullptr);
        cout.setf(ios::fixed);
        cout.precision(20);
        int n, m;
        cin >> n >> m;
        for (int i = 0; i < n - 1; ++i) {
            int f, s;
            cin >> f >> s;
            auto p1 = make_pair(f, s);
            auto p2 = make_pair(s, f);
            costmap[p1] = 1;
            costmap[p2] = 1;
            neighbourmap[f].insert(s);
            neighbourmap[s].insert(f);
        }
        for (int i = 0; i < m; ++i) {
            int c;
            cin >> c;
            attkcities.insert(c);
        }
        int cost = INT_MAX, ct = 0;
        for (int city : attkcities) {
            global = 0;
            set<int> visited, visitedpath;
            global = dfs(city, city, visited, visitedpath);
            if (global < cost) {
                ct = city;
                cost = global;
            }
        }
        cout << ct << "\n" << cost << endl;
    }
};
