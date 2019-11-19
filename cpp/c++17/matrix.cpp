#include <bits/stdc++.h>
using namespace std;

struct Grid {
    int num;
    unordered_set<int> left, right, above, below;
};

ostream& operator<<(ostream& os, const unordered_set<int>& s)
{
    os << "[";
    for (int item : s) os << item << ", ";
    os << "]";
    return os;
}

ostream& operator<<(ostream& os, const Grid& grid) {
    os
        << "left=" << grid.left
        << "right=" << grid.right
        << "above=" << grid.above
        << "below=" << grid.below;
    return os;
}

enum DIRECTION {
    UNKNOWN = -1,
    LEFT,
    RIGHT,
    ABOVE,
    BELOW,
};

DIRECTION getDirection(const string& s)
{
    if (s.find("left") != string::npos) return LEFT;
    if (s.find("right") != string::npos) return RIGHT;
    if (s.find("above") != string::npos) return ABOVE;
    if (s.find("below") != string::npos) return BELOW;
    return UNKNOWN;
}

int main()
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cout.setf(ios::fixed); cout.precision(20);

    //const function<int(const Grid&)>& GridHash = [](const Grid& g) { return hash<int>()(g.num); };
    //const function<bool(const Grid&, const Grid&)>& GridEquality = [](const Grid& lhs, const Grid& rhs) { return lhs.num == rhs.num;};

    unordered_map<int, Grid> inputs;
    string line;
    while (getline(cin, line)) {
        if (line.empty()) break;
        DIRECTION dir = getDirection(line);
        if (dir == UNKNOWN) continue;
        vector<string> tokens;
        stringstream ss(line);
        string token;
        while (ss >> token) {
            tokens.push_back(token);
        }
        int a = stoi(tokens[0]);
        int b = stoi(tokens[tokens.size() - 1]);
        switch(dir)
        {
            case LEFT:
                inputs[a].right.insert(b);
                inputs[b].left.insert(a);
                break;
            case RIGHT:
                inputs[a].left.insert(b);
                inputs[b].right.insert(a);
                break;
            case ABOVE:
                inputs[a].below.insert(b);
                inputs[b].above.insert(a);
                break;
            case BELOW:
                inputs[a].above.insert(b);
                inputs[b].below.insert(a);
                break;
        }
    }
    unordered_map<int, pair<int, int> > points;
    for (auto& pair : inputs) {
        int key = pair.first;
        const Grid& value = pair.second;

        if (points.size() == 0) {
            points[key] = make_pair(0, 0);
        }

    }
}